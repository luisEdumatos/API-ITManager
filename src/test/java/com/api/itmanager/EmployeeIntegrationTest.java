package com.api.itmanager;

//@TestPropertySource(locations="classpath:test.properties")
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EmployeeIntegrationTest extends ApiItmanagerApplicationTests {
/*
    private MockMvc mockMvc;

    private Faker clientFaker;

    private Faker employeeFaker;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EmployeeController employeeController;

    @Autowired
    private ClientController clientController;

    @BeforeAll
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
        this.clientFaker = new Faker(new Locale("pt-BR"));
        this.employeeFaker = new Faker(new Locale("pt-BR"));
        clientController.createClient(createClientRequestFaker());
    }

    private ClientRequest createClientRequestFaker() {
        return ClientRequest.builder()
                .name(clientFaker.company().name())
                .address(clientFaker.address().fullAddress())
                .cnpj(clientFaker.numerify("##############"))
                .build();
    }

    @Test
    public void testListAll() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/employee")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testCreateEmployee() throws Exception {
        EmployeeRequest request = createEmployeeRequestFaker();

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/employee")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    private EmployeeRequest createEmployeeRequestFaker() {
        return EmployeeRequest.builder()
                .clientId(1L)
                .name(employeeFaker.name().name())
                .admissionDate(employeeFaker.numerify("##/##/####"))
                .build();
    }

    @Test
    public void testCreateEmployeeWithError() throws Exception {
        EmployeeRequest request = createEmployeeRequestFaker();

        request.setAdmissionDate("01/01/2001123");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/employee")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void testFindByIdIfEmployeeExists() throws Exception {
        EmployeeRequest request = createEmployeeRequestFaker();

        employeeController.createEmployee(request);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/employee/1"))
                    .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testFindByIdIfEmployeeNotExists() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/employee/25")).andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void testUpdateEmployee() throws Exception {
        EmployeeRequest request = createEmployeeRequestFaker();

        employeeController.createEmployee(request);

        EmployeeRequest requestToUpdate = createEmployeeRequestFaker();

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/employee/1")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(requestToUpdate)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testUpdateEmployeeWithError() throws Exception {
        EmployeeRequest request = createEmployeeRequestFaker();

        employeeController.createEmployee(request);

        request.setAdmissionDate(employeeFaker.numerify("##/##/#####"));

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/employee/1")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void testDeleteEmployeeByIdIfExists() throws Exception {
        EmployeeRequest request = createEmployeeRequestFaker();

        employeeController.createEmployee(createEmployeeRequestFaker());

        employeeController.createEmployee(createEmployeeRequestFaker());

        employeeController.createEmployee(request);

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/employee/3"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testDeleteEmployeeByIdIfNotExists() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/employee/25"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

 */
}
