package sad.humanresourcemanagementsystem.daoi;

import java.util.List;

import sad.humanresourcemanagementsystem.model.Notification;

public interface NotificationDAOI {
int insertNotification(Notification notification);
boolean updateNofication(Notification notification);
boolean deleteNotification(int id);
List<Notification> getNotifications();
Notification getNotificationById(int id);



}
