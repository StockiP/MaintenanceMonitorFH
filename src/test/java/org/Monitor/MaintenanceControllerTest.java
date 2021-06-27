//region imports
package org.Monitor;

import com.sun.tools.javac.Main;
import org.Monitor.MaintenanceController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;
//endregion

public class MaintenanceControllerTest {

    //this test is checking to see if getStatus is returning the right response.


    //this test is checking if the right responsecode is returned.
    @Test
    public void Test_getStatus_shouldReturnOk(){
        //Arrange
        MaintenanceController controller = new MaintenanceController();
        //Act
        String response = controller.getStatus().toString();
        //Assert
        Assertions.assertEquals(
                "OutboundJaxrsResponse{status=200, reason=OK, hasEntity=true, closed=false, buffered=false}",
                response);
    }

    @Test
    public void Test_getStatusString_shouldReturnDash(){
        MaintenanceController controller = new MaintenanceController();
        controller.setStatus("-");
        String response = controller.getStatus().getEntity().toString();
        Assertions.assertEquals("-", response);
    }



    //this test is testing a null value and the behaviour
    @Test
    public void Test_setStatusNull_shouldReturnPrevStatus(){
        MaintenanceController controller = new MaintenanceController();
        controller.setStatus("-");
        String response = controller.setStatus(null);
        Assertions.assertEquals("-", response);
    }

    //this test is checking if status can be set.
    @Test
    public void Test_setStatus_shouldreturnsentStatus(){

        MaintenanceController controller = new MaintenanceController();
        String response = controller.setStatus("+");
        Assertions.assertEquals("+", response);
    }
}
