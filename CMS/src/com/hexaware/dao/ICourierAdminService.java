package com.hexaware.dao;
//TASK6
import com.hexaware.entity.Employee;

public interface ICourierAdminService {
    int addCourierStaff(Employee obj);
    /** Add a new courier staff member to the system.
    * @param name The name of the courier staff member.
    * @param contactNumber The contact number of the courier staff member.
    * @return The ID of the newly added courier staff member.
    */
}
