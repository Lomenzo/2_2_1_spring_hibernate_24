package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();
//   Car getCarBySeriesAndModel (int series, String model);
   User getUserByCarParams (int insertseries, String insertmodel);
}
