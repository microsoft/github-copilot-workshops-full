When new operations are added to the API, include the necessary unit tests for the controller, service, and repository layers, if applied.

We use WebMvcTest to test the controller layer of our application. It is used in combination with @MockitoBean to provide mock implementations for required dependencies.

We use Mockito to mock the dependencies of our controller and service classes. We use @Mock and @InjectMocks. If needed use @BeforeEach to initialize test data.

We use @DataJpaTest to test the repository layer of our application. 