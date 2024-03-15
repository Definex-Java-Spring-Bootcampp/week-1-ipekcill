**Java Frameworks**

1. **Spring Framework**

Spring, Java platformlarını kullanarak geniş çaplı projeler geliştirilmesine olanak sağlar. İçerisinde pek çok modül barındırır. En önemli modüllerinden birisi Spring Core Container’dir. Bu modül Dependency injection ve Inversion of Control mekanizmaları gibi temel özellikleri sağlar. Diğer en önemli modüllerinden birisi de Spring MVC (Model-View-Controller).  

Spring Framwork daha hızlı uygulama geliştirmeyi ve uygulamaların kolay test edilmesini sağlar. Kullanımı basittir.

Bağımlılıkların yönetilmesini sağlar.

Güvenliği arttırır.

Web geliştirme imkanı sunar.

Dependency injection kod örneği :

@RequiredArgsConstructor

public class EmployeeController {

`    `private final EmployeeService employeeService;

Yukarıdaki kodda, EmployeeController sınıfının constructor method EmployeeService tipinde bir parameter alır. (Constructor @RequiredArgsConstructor anotasyonu ile uygulanmıştır.) Bu parameter, EmployeeService sınıfının bir örneği olacak ve Spring tarafından enjekte edilecek. 

1. **Hibernate**

Hibernate aslında ORM ‘nin (Object Relational Mapping) bir kütüphanesidir. Veritabanı işlemlerimizi model sınıflarımıza göre sağlar. Bu işlemleri kolaylaştırır. Uygulama ile herhangi bir veritabanının iletişime geçmesine izin verir. SQL sorguları yazmaya gerek kalmaz.Model sınıflarımız veritabanında bir tabloyu temsil eder.

Kod örneği: 

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {


`    `@Id
`    `@GeneratedValue(strategy = GenerationType.*IDENTITY*)
`    `private Long id;
`    `private String name;
`    `private String surname;
`    `private String email;
}

@ Entity annotation’I Hibernate frameworkünden gelir. Java class’ının bir tabloyu temsil ettiğini söyler.  Bir Java class’ının JPA (Java Persistence API) varlığını temsil ettiğini belirtir. Hibernate JPA standardlarını uygular. JPA varlıklarını yönetir.

1. **Dropwizard**

Dropwizard, RESTful web servislerinin hızlı bir şekilde geliştirilmesine  olanak sağlayan bir frameworktür. Özellikle Java microservices oluşturmak için uygundur. Birkaç önemli Java kütüphanesini bir araya getirir. Spring Boot ile benzer olsa da Dropwizard özellikle RESTful web servisleri için geliştirilmiştir. 

1. **Struts**

Struts’ da Dropwizard ve Spring Boot gibi web uygulamaları geliştirmek için tasarlanmıştır. 

MVC’ ye dayanır.

**SOA (Service-Oriented Architecture)**

Yazılım mimarisi için bir yaklaşımdır. Büyük mimarilerin parçalara ayrılıp birbirleriyle  network üzerinden iletişim kuran servislerden oluşan hali olarak tanımlayabiliriz. Büyük servislerin kodlanması ve yönetilmesi bir yerden sonra zorlaşır. Bu noktada servis mimarisi devreye girer. Girdiğimiz sitelerin arkasında tek bir uygulama yerine parçalara ayrılmış uygulamalar vardır. Tek parça uygulamalara monolitik uygulamalar denir. Çoğu uygulama aslında monolitik başlar. Ölçeklenebildiği ve yönetilebiliği sürece bunda bir sıkıntı yoktur. Zamanla servis mimarisine geçerler. 

Temel özellikler

Her service belirli bir iş yapar (Business logic)

Servisin içindeki kod,, servisi çağıranları ilgilendirmez. O servis bir API verir. Servisin Java da mı yazıldığı nasıl yazıldığı çağıran servisin umrunda olmadan bir site inşaa edebilirler.

Service işini yapmak için başka bir service çağırabilir. Örneğin basit bir müşteri yönetim sistemini ele alalım. Customer sınıfı müşteri verilerini temsil eder. CustomerService Inteface’i müşteri verilerini işlemek için gerekli metotları tanımlar. CustomerServiceImpl sınıfı bu servisi uygular, müşteri verilerini saklar. ( Örneğin map’te tutar.) CustomerManagmentApp sınıfı’da müşteri servisini kullanarak yeni bir müşteri ekler. Müşterinin bilgilerini alır, yazdırır. Bu örnekte basit bir müşteri yönetim sisteminin servis odaklı mimariye  uygun şekilde uyarlanmıştır.

**Web Service**

Uygulamaların birbirleriyle haberleşmesinde kullanılır. Örneğin mobil ve web uygulamasında mobile gelen bilgi webde de yer almalıdır. Bu durum web servisler ile sağlanır. Bir servis, bir işlevi yerine getirirken API aracılığıyla istekleri alır ve sonuçları geri gönderir.

Web servisler, client tarafından gönderilen requestleri yorumlayarak istemciye yapısında bulundurduğu bilgileri aktarır. Örneğin; TCMB döviz kurlarını almak istersek kurumun vermiş olduğu web servisten istediğimiz veriyi alıp işlemlerimizi yapabiliriz.

**Restful Service**

Client ve server arasında hızlı ve kolay bir şekilde iletişim kurulmasını sağlayan web tabanlı çalışan bir servis mimarisidir. Client (istemci) tarayıcı,mobil uygulama, masaüstü uygulama gibi programlar vasıtasıyla server ile internet üzerinden veri alışverişinde bulunur. İstek atar ve sunucudan response bekler. 

XML ve Json veri tiplerini kullanır. 

Http protokolü üzerinden haberleşir. Http status codes ile sağlanır. (200, 201, 204, vb.)

İstemci GET (Read), POST (Create), PUT (Update), DELETE ile istek atar. Bunlar Http metotlarıdır. (CRUD Operations)

Platform ve dil bağımsızdır. REST mimarisinin tüm özelliklerini yerine getiren servislere Restful web servisleri denir. 

Aşağıda Rest Api Crud örneği paylaştım.

public class EmployeeController {

`    `private final EmployeeService employeeService;
`    `@PostMapping("/save")
`    `public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
`        `Employee savedEmployee = employeeService.saveEmployee(employee);
`        `return new ResponseEntity<>(savedEmployee, HttpStatus.*CREATED*);
`    `}

`    `@GetMapping("/all")
`    `public ResponseEntity<List<Employee>> getAllEmployee(){
`        `List<Employee> allEmployee = employeeService.getAllEmployee();
`        `return new ResponseEntity<>(allEmployee, HttpStatus.*OK*);
`    `}

`    `@GetMapping("/{id}")
`    `public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
`        `Employee employee = employeeService.getEmployeeById(id);
`        `return new ResponseEntity<>(employee, HttpStatus.*OK*);
`    `}

`    `@PutMapping("/update/{id}")
`    `public ResponseEntity<Employee> updateEmployeeById(@RequestBody Employee employee){
`        `Employee updatedEmployee = employeeService.updateEmployee(employee);
`        `return new ResponseEntity<>(updatedEmployee, HttpStatus.*OK*);
`    `}

`    `@DeleteMapping("/delete/{id}")
`    `public ResponseEntity<Void> deleteEmployeeById(@PathVariable Long id){
`        `employeeService.deleteEmployeeById(id);
`        `return new ResponseEntity<>(HttpStatus.*ACCEPTED*);
`    `}

**HTTP Methods**

GET: Sunucudan veri almak/okumak için kullanılır. GET metodu ile sorgu metinleri URL içinde gönderilebilir.* 

POST: Bu metod ile kayıt oluşturulır. İstek parametreleri hem URL içinde hem de mesaj gövdesinde gönderilebilir. Mesaj gövdesinde gönderilmesi daha uygundur.

PUT: Bu metod varolan ir kaydı güncellemek için kullanılır. Hangi kaynağı güncelleyeceksek o kaynağın id’sini göndeririz.

DELETE: Bu metod ile sunucudaki herhangi bir veriyi silebiliriz.

PATCH : Güncelleme için kullanılır. 

Bunlar başta gelen metotlardır.
