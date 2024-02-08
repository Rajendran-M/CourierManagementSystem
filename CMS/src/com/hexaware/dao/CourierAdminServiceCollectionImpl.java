package com.hexaware.dao;
//TASK8
import com.hexaware.entity.CourierCompanyCollection;
import com.hexaware.entity.Employee;

public class CourierAdminServiceCollectionImpl extends CourierUserServiceCollectionImpl implements ICourierAdminService {

    public CourierAdminServiceCollectionImpl(CourierCompanyCollection companyObj) {
        super(companyObj);
    }

    @Override
    public int addCourierStaff(Employee obj) {
            getCompanyObj().getEmployeeDetails().add(obj);

      
             return generateEmployeeId();
    }

    private CourierCompanyCollection getCompanyObj() {

		return null;
	}

	

    private int generateEmployeeId() {
      
        return (int) System.currentTimeMillis();
    }
}
