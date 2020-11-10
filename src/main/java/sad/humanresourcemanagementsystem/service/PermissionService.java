package sad.humanresourcemanagementsystem.service;

import sad.humanresourcemanagementsystem.dao.DAOFactory;
import sad.humanresourcemanagementsystem.daoi.PermissionDAOI;
import sad.humanresourcemanagementsystem.model.Permission;

public class PermissionService {
private PermissionDAOI permissionDAOI;
public PermissionService() {
	permissionDAOI = DAOFactory.getPermissionDAO();
}
public int insertPermission(Permission permission) {
	return permissionDAOI.insertPermission(permission);
}
public boolean updatePermission(Permission permission) {
	return permissionDAOI.updatePermission(permission);
}
public Permission getPermissionByStaffName(String staffName) {
	return permissionDAOI.getPermissionByStaffName(staffName);
}

}
