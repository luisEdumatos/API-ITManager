package com.api.itmanager.modules.employee_device.controller;

import com.api.itmanager.modules.employee_device.service.EmployeeDeviceService;
import com.api.itmanager.util.response.Response;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/employee")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeeDeviceController {

    private EmployeeDeviceService employeeDeviceService;

    @ApiOperation(value = "Associa um Colaborador a um Equipamento")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Associação efetuada com sucesso"),
            @ApiResponse(code = 405, message = "Falta de ID no parâmetro"),
            @ApiResponse(code = 404, message = "Colaborador ou Equipamento não foram encontrados"),
    })
    @PutMapping(value = "/{idEmployee}/device/{idDevice}", produces = "application/json")
    public Response joinEmployeeDevice(@PathVariable Long idEmployee, @PathVariable Long idDevice) {
        return employeeDeviceService.joinEmployeeDevice(idEmployee, idDevice);
    }

    @ApiOperation(value = "Remover relação entre Colaborador e Equipamento")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Relação removida com sucesso"),
            @ApiResponse(code = 405, message = "Falta de ID no parâmetro"),
            @ApiResponse(code = 404, message = "Colaborador ou Equipamento não foram encontrados")
    })
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{idEmployee}/device/{idDevice}")
    public Response removeEmployeeDevice(@PathVariable Long idEmployee, @PathVariable Long idDevice) {
        return employeeDeviceService.removeEmployeeDevice(idEmployee, idDevice);
    }

    //TODO Implementar findAllDeviceByEmployeeId
    //TODO Implementar findAllEmployeeByDeviceId
}
