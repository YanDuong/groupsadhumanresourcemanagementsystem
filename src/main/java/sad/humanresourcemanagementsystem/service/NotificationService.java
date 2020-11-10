package sad.humanresourcemanagementsystem.service;
import java.util.List;

import sad.humanresourcemanagementsystem.dao.DAOFactory;
import sad.humanresourcemanagementsystem.daoi.NotificationDAOI;
import sad.humanresourcemanagementsystem.model.Notification;
public class NotificationService {
private NotificationDAOI notificationDAOI;
public NotificationService() {
	notificationDAOI = DAOFactory.getNotificationDAO();
}
public int insertNotification(Notification notification) {
	return notificationDAOI.insertNotification(notification);
}
public boolean updateNofication(Notification notification) {
	return notificationDAOI.updateNofication(notification);
}
public boolean deleteNotification(int id) {
	return notificationDAOI.deleteNotification(id);
}
public List<Notification> getNotifications() {
	return notificationDAOI.getNotifications();
}
public Notification getNotificationById(int id) {
	return notificationDAOI.getNotificationById(id);
}

}
