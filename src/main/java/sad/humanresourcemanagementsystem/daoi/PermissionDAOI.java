package sad.humanresourcemanagementsystem.daoi;

import sad.humanresourcemanagementsystem.model.Permission;

public interface PermissionDAOI {
int insertPermission(Permission permission);
boolean updatePermission(Permission permission);
Permission getPermissionByStaffName(String staffName);

}
