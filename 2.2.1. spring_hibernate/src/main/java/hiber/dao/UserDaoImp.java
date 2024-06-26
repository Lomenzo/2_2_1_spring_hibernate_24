package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }
//   @Override
//   public Car getCarBySeriesAndModel (int insertseries, String insertmodel){
//      TypedQuery<Car> q = sessionFactory.getCurrentSession().createQuery("from Car WHERE series = 2106");
////      q.setParameter("s", series);
////      q.setParameter("m", model);
//      return q.getSingleResult();

//      Query q2 = sessionFactory.getCurrentSession().createQuery("from User WHERE car = :i");
//      q2.setParameter("i", car.getId());
//      return (User) q2.getSingleResult();
//   }

   @Override
   public User getUserByCarParams (int insertseries, String insertmodel) {
      TypedQuery<User> q = sessionFactory.getCurrentSession().createQuery("from User WHERE car.series = :s and car.model =:m");
      q.setParameter("s", insertseries);
      q.setParameter("m", insertmodel);

      return q.getResultList().stream().findFirst().get();
   }
}
