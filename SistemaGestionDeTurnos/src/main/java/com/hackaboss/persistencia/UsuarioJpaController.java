
package com.hackaboss.persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.hackaboss.logica.Turno;
import com.hackaboss.logica.Usuario;
import com.hackaboss.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;


public class UsuarioJpaController implements Serializable {
    
    public UsuarioJpaController () {
        emf = Persistence.createEntityManagerFactory("TurneroPU");
    }

    public UsuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuario usuario) {
        if (usuario.getListaTurnos() == null) {
            usuario.setListaTurnos(new ArrayList<Turno>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Turno> attachedListaTurnos = new ArrayList<Turno>();
            for (Turno listaTurnosTurnoToAttach : usuario.getListaTurnos()) {
                listaTurnosTurnoToAttach = em.getReference(listaTurnosTurnoToAttach.getClass(), listaTurnosTurnoToAttach.getId());
                attachedListaTurnos.add(listaTurnosTurnoToAttach);
            }
            usuario.setListaTurnos(attachedListaTurnos);
            em.persist(usuario);
            for (Turno listaTurnosTurno : usuario.getListaTurnos()) {
                Usuario oldUsuarioOfListaTurnosTurno = listaTurnosTurno.getUsuario();
                listaTurnosTurno.setUsuario(usuario);
                listaTurnosTurno = em.merge(listaTurnosTurno);
                if (oldUsuarioOfListaTurnosTurno != null) {
                    oldUsuarioOfListaTurnosTurno.getListaTurnos().remove(listaTurnosTurno);
                    oldUsuarioOfListaTurnosTurno = em.merge(oldUsuarioOfListaTurnosTurno);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuario usuario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario persistentUsuario = em.find(Usuario.class, usuario.getId());
            List<Turno> listaTurnosOld = persistentUsuario.getListaTurnos();
            List<Turno> listaTurnosNew = usuario.getListaTurnos();
            List<Turno> attachedListaTurnosNew = new ArrayList<Turno>();
            for (Turno listaTurnosNewTurnoToAttach : listaTurnosNew) {
                listaTurnosNewTurnoToAttach = em.getReference(listaTurnosNewTurnoToAttach.getClass(), listaTurnosNewTurnoToAttach.getId());
                attachedListaTurnosNew.add(listaTurnosNewTurnoToAttach);
            }
            listaTurnosNew = attachedListaTurnosNew;
            usuario.setListaTurnos(listaTurnosNew);
            usuario = em.merge(usuario);
            for (Turno listaTurnosOldTurno : listaTurnosOld) {
                if (!listaTurnosNew.contains(listaTurnosOldTurno)) {
                    listaTurnosOldTurno.setUsuario(null);
                    listaTurnosOldTurno = em.merge(listaTurnosOldTurno);
                }
            }
            for (Turno listaTurnosNewTurno : listaTurnosNew) {
                if (!listaTurnosOld.contains(listaTurnosNewTurno)) {
                    Usuario oldUsuarioOfListaTurnosNewTurno = listaTurnosNewTurno.getUsuario();
                    listaTurnosNewTurno.setUsuario(usuario);
                    listaTurnosNewTurno = em.merge(listaTurnosNewTurno);
                    if (oldUsuarioOfListaTurnosNewTurno != null && !oldUsuarioOfListaTurnosNewTurno.equals(usuario)) {
                        oldUsuarioOfListaTurnosNewTurno.getListaTurnos().remove(listaTurnosNewTurno);
                        oldUsuarioOfListaTurnosNewTurno = em.merge(oldUsuarioOfListaTurnosNewTurno);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = usuario.getId();
                if (findUsuario(id) == null) {
                    throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario usuario;
            try {
                usuario = em.getReference(Usuario.class, id);
                usuario.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.", enfe);
            }
            List<Turno> listaTurnos = usuario.getListaTurnos();
            for (Turno listaTurnosTurno : listaTurnos) {
                listaTurnosTurno.setUsuario(null);
                listaTurnosTurno = em.merge(listaTurnosTurno);
            }
            em.remove(usuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuario> findUsuarioEntities() {
        return findUsuarioEntities(true, -1, -1);
    }

    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return findUsuarioEntities(false, maxResults, firstResult);
    }

    private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuario.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Usuario findUsuario(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuario> rt = cq.from(Usuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    Usuario findUserByEmail(String email) {
        EntityManager em =getEntityManager();
        
        try {
            String consulta = "SELECT usu FROM Usuario usu WHERE usu.email = :email";
            Query query = em.createQuery(consulta);
            query.setParameter("email",email);
            return (Usuario)query.getSingleResult();
        } catch(NoResultException e) {
                return null;
                }
        
        finally {
            em.close();
        }
    }
    
}
