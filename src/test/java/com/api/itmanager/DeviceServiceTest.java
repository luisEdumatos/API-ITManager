package com.api.itmanager;

import com.api.itmanager.modules.client.model.Client;
import com.api.itmanager.modules.client.repository.ClientRepository;
import com.api.itmanager.modules.infrastructure.device.dto.DeviceRequest;
import com.api.itmanager.modules.infrastructure.device.dto.DeviceResponse;
import com.api.itmanager.modules.infrastructure.device.model.Device;
import com.api.itmanager.modules.infrastructure.device.repository.DeviceRepository;
import com.api.itmanager.modules.infrastructure.device.service.DeviceService;
import com.api.itmanager.modules.infrastructure.device.workstation.dto.WorkStationRequest;
import com.api.itmanager.modules.infrastructure.device.workstation.dto.WorkStationResponse;
import com.api.itmanager.modules.infrastructure.device.workstation.model.WorkStation;
import com.api.itmanager.util.exception.ClientNotFoundException;
import com.api.itmanager.util.response.Response;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@RunWith(SpringRunner.class)
public class DeviceServiceTest extends ApiItmanagerApplicationTests {

    private Faker clientFaker;

    private Faker deviceFaker;

    @Autowired
    private DeviceService deviceService;

    @MockBean
    private DeviceRepository deviceRepository;

    @MockBean
    private ClientRepository clientRepository;

    @Before
    public void setup() {
        this.deviceFaker = new Faker(new Locale("pt-BR"));
        this.clientFaker = new Faker(new Locale("pt-BR"));

        Device device1 = createDeviceFaker(1L);
        Device device2 = createDeviceFaker(2L);
        Device device3 = createDeviceFaker(3L);

        WorkStation workStation1 = createWorkSationFaker(1L);
        WorkStation workStation2 = createWorkSationFaker(1L);
        WorkStation workStation3 = createWorkSationFaker(1L);

        Client client1 = createClientFaker();

        Mockito.when(deviceRepository.findAllByDtypeAndClientID(1L, client1.getId())).thenReturn(Arrays.asList(device1, device2, device3));
        Mockito.when(deviceRepository.findAllByDtypeAndClientID(2L, client1.getId())).thenReturn(Arrays.asList(workStation1, workStation2, workStation3));
        Mockito.when(deviceRepository.save(Mockito.any(Device.class))).thenReturn(device1);
        Mockito.when(deviceRepository.save(Mockito.any(WorkStation.class))).thenReturn(workStation1);
        Mockito.when(clientRepository.findById(client1.getId())).thenReturn(Optional.of(client1));
    }

    private Client createClientFaker() {
        return Client.builder()
                .id(1L)
                .name(clientFaker.company().name())
                .address(clientFaker.address().fullAddress())
                .cnpj(clientFaker.numerify("##############"))
                .build();
    }

    private Device createDeviceFaker(Long id) {

        var device = new Device();
        device.setId(id);
        device.setClientID(createClientFaker());
        device.setBrand(deviceFaker.commerce().material());
        device.setCategory(deviceFaker.commerce().department());
        device.setDescription(deviceFaker.lorem().paragraph());
        device.setIpAddress(deviceFaker.numerify("############"));
        device.setMacAddress(deviceFaker.numerify("############"));
        device.setModel(deviceFaker.commerce().productName());

        return device;
    }

    private WorkStation createWorkSationFaker(Long id) {

        var device = new WorkStation();
        device.setId(id);
        device.setClientID(createClientFaker());
        device.setBrand(deviceFaker.commerce().material());
        device.setCategory(deviceFaker.commerce().department());
        device.setDescription(deviceFaker.lorem().paragraph());
        device.setIpAddress(deviceFaker.numerify("############"));
        device.setMacAddress(deviceFaker.numerify("############"));
        device.setModel(deviceFaker.commerce().productName());
        device.setLocation(deviceFaker.commerce().department());
        device.setLabel(deviceFaker.code().toString());
        device.setManufacturingDate(deviceFaker.date().toString());
        device.setOperationalSystem(deviceFaker.commerce().material());
        device.setRam(deviceFaker.commerce().material());
        device.setHdssd(deviceFaker.commerce().material());
        device.setProcessor(deviceFaker.commerce().material());
        device.setGenProcessor(deviceFaker.commerce().material());
        device.setCondition(deviceFaker.commerce().material());

        return device;
    }

    @Test
    public void testeListAllDevicesByClientId() {
        List<DeviceResponse> listDeviceResponse = deviceService.findAllDevicesByClientId(1L);
        Assert.assertEquals(3L, listDeviceResponse.size());
    }

    @Test
    public void testeListAllWorkStationsByClientId() {
        List<WorkStationResponse> listDeviceResponse = deviceService.findAllWorkStationsByClientId(1L);
        Assert.assertEquals(3L, listDeviceResponse.size());
    }

    @Test
    public void testCreateDevice() throws ClientNotFoundException {
        DeviceRequest request = DeviceRequest.builder()
                .brand(deviceFaker.commerce().material())
                .category(deviceFaker.commerce().department())
                .description(deviceFaker.lorem().paragraph())
                .model(deviceFaker.commerce().productName())
                .ipAddress(deviceFaker.numerify("############"))
                .macAddress(deviceFaker.numerify("############"))
                .clientID(1L)
                .build();


        Response response = deviceService.createDevice(request);

        Assert.assertEquals((Integer) HttpStatus.CREATED.value(), response.getStatus());
        Assert.assertEquals("Created device with ID 1", response.getMessage());
    }

    @Test
    public void testeCreateWorkstation() throws ClientNotFoundException {

        WorkStationRequest request = new WorkStationRequest();
        request.setClientID(1L);
        request.setBrand(deviceFaker.commerce().material());
        request.setCategory(deviceFaker.commerce().department());
        request.setDescription(deviceFaker.lorem().paragraph());
        request.setIpAddress(deviceFaker.numerify("############"));
        request.setMacAddress(deviceFaker.numerify("############"));
        request.setModel(deviceFaker.commerce().productName());
        request.setLocation(deviceFaker.commerce().department());
        request.setLabel(deviceFaker.code().toString());
        request.setManufacturingDate(deviceFaker.date().toString());
        request.setOperationalSystem(deviceFaker.commerce().material());
        request.setRam(deviceFaker.commerce().material());
        request.setHdssd(deviceFaker.commerce().material());
        request.setProcessor(deviceFaker.commerce().material());
        request.setGenProcessor(deviceFaker.commerce().material());
        request.setCondition(deviceFaker.commerce().material());

        Response response = deviceService.createWorkStation(request);

        Assert.assertEquals((Integer) HttpStatus.CREATED.value(), response.getStatus());
        Assert.assertEquals("Created workstation with ID 1", response.getMessage());
    }
}
