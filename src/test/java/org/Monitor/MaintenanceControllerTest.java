package org.Monitor;

import com.sun.tools.javac.Main;
import org.Monitor.MaintenanceController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

public class MaintenanceControllerTest {

    @Test
    public void test_getStatusString_shouldReturnDash(){
        MaintenanceController controller = new MaintenanceController();
        controller.setStatus("-");
        String response = controller.getStatus().getEntity().toString();
        Assertions.assertEquals("-", response);
    }
    @Test
    public void test_getStatus_shouldReturnOk(){
        //Arrange
        MaintenanceController controller = new MaintenanceController();
        //Act
        String response = controller.getStatus().toString();
        //Assert
        Assertions.assertEquals("OutboundJaxrsResponse{status=200, reason=OK, hasEntity=true, closed=false, buffered=false}", response);
    }
    @Test
    public void test_setStatus_shouldreturnsentStatus(){

        MaintenanceController controller = new MaintenanceController();
        String response = controller.setStatus("+");
        Assertions.assertEquals("+", response);
    }
    @Test
    public void test_setStatusNull_shouldReturnPrevStatus(){
        MaintenanceController controller = new MaintenanceController();
        controller.setStatus("-");
        String response = controller.setStatus(null);
        Assertions.assertEquals("-", response);
    }
}
