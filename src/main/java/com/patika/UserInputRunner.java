package com.patika;

import com.patika.kredinbizdenservice.enums.ApplicationStatus;
import com.patika.kredinbizdenservice.enums.LoanType;
import com.patika.kredinbizdenservice.enums.SectorType;
import com.patika.kredinbizdenservice.enums.VehicleStatusType;
import com.patika.kredinbizdenservice.factory.ConcreteLoanFactory;
import com.patika.kredinbizdenservice.factory.CreditCardFactory;
import com.patika.kredinbizdenservice.factory.LoanFactory;
import com.patika.kredinbizdenservice.model.*;
import com.patika.kredinbizdenservice.service.UserServiceImpl;
import com.patika.onlineshoppingservice.enums.ProductType;
import com.patika.onlineshoppingservice.models.Bill;
import com.patika.onlineshoppingservice.models.Customer;
import com.patika.onlineshoppingservice.models.Order;
import com.patika.onlineshoppingservice.models.OrderItem;
import com.patika.onlineshoppingservice.service.CustomerServiceImpl;
import com.patika.onlineshoppingservice.service.OrderItemServiceImpl;
import com.patika.onlineshoppingservice.service.OrderServiceImpl;
import com.patika.onlineshoppingservice.service.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserInputRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which application runner do you want to execute ? (1-kredinbizden/2-onlineshopping)");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> kredinBizdenRunner();
            case 2 -> onlineShoppingRunner();
            default -> System.out.println("Invalid choice");
        }
        scanner.close();
    }

    private void kredinBizdenRunner() {
        UserServiceImpl userService = new UserServiceImpl();
        User user1 = new User("Ipek", "Cil", "ipek@gmail.com", "ppp1", "5397868622", true);

        User user2 = new User("Onur", "Cil", "onur@gmail.com", "ppp2", "5397868623", true);

        User user3 = new User("Cem", "Dırman", "cemdrman@gmail.com", "ppp3", "5397868624", true);

        userService.addUser(user1);
        userService.addUser(user2);
        userService.addUser(user3);

        System.out.println("------------------------------------------------------------------------------------------------------------");

        BankManager bankManager = BankManager.getInstance();
        Bank finansBank = bankManager.getBank("FinansBank");
        Bank garantiBank = bankManager.getBank("GarantiBank");
        Bank halkBank = bankManager.getBank("HalkBank");

        LoanFactory loanFactory = new ConcreteLoanFactory();
        CreditCardFactory creditCardFactory = new CreditCardFactory();

        Product consumerLoan1 = loanFactory.createLoan(LoanType.CONSUMER_LOAN, "Maaş Müşterilerimize Özel", new BigDecimal("25000"), 24, 4.89, null);
        consumerLoan1.setBank(finansBank);
        Product consumerLoan2 = loanFactory.createLoan(LoanType.CONSUMER_LOAN, "Maaş Müşterilerimize Özel", new BigDecimal("25000"), 24, 4.77, null);
        consumerLoan2.setBank(garantiBank);
        Product consumerLoan3 = loanFactory.createLoan(LoanType.CONSUMER_LOAN, "Maaş Müşterilerimize Özel", new BigDecimal("25000"), 24, 4.81, null);
        consumerLoan3.setBank(halkBank);

        Product houseLoan1 = loanFactory.createLoan(LoanType.HOUSE_LOAN, "İlk Evim Kredisi", new BigDecimal("1250000"), 180, 3.34, null);
        houseLoan1.setBank(finansBank);
        Product houseLoan2 = loanFactory.createLoan(LoanType.HOUSE_LOAN, "İlk Evim Kredisi", new BigDecimal("1250000"), 180, 3.61, null);
        houseLoan2.setBank(garantiBank);
        Product houseLoan3 = loanFactory.createLoan(LoanType.HOUSE_LOAN, "İlk Evim Kredisi", new BigDecimal("1250000"), 180, 3.16, null);
        houseLoan3.setBank(halkBank);

        Product vehicleLoan1 = loanFactory.createLoan(LoanType.VEHICLE_LOAN, "Taşıt Kredisi", new BigDecimal("400000"), 12, 4.01, VehicleStatusType.NEW);
        vehicleLoan1.setBank(finansBank);
        Product vehicleLoan2 = loanFactory.createLoan(LoanType.VEHICLE_LOAN, "Taşıt Kredisi", new BigDecimal("400000"), 12, 3.99, VehicleStatusType.NEW);
        vehicleLoan2.setBank(garantiBank);
        Product vehicleLoan3 = loanFactory.createLoan(LoanType.VEHICLE_LOAN, "Taşıt Kredisi", new BigDecimal("400000"), 12, 4.02, VehicleStatusType.NEW);
        vehicleLoan3.setBank(halkBank);

        Product creditCard1 = creditCardFactory.createCreditCard("Basic Credit Card", new BigDecimal("100000"), new BigDecimal("200000"));
        Product creditCard2 = creditCardFactory.createCreditCard("Medium Credit Card", new BigDecimal("100000"), new BigDecimal("140000"));
        Product creditCard3 = creditCardFactory.createCreditCard("Premium Credit Card", new BigDecimal("100000"), new BigDecimal("180000"));

        Campaign campaign1 = new Campaign("Bonus BigCampaign", "+5 installments possible", LocalDate.of(2024, 8, 30), SectorType.MARKET);
        Campaign campaign2 = new Campaign("BonusTeen BigCampaign", "+5 installments possible and fee-free", LocalDate.of(2024, 8, 30), SectorType.MARKET);
        Campaign campaign3 = new Campaign("CardFinans Campaign", "+3 installments possible for hotel reservations", LocalDate.of(2024, 6, 15), SectorType.TRAVELS);
        Campaign campaign4 = new Campaign("CardFinans BigCampaign for Trendyol ", "Up to +5 installments without interest", LocalDate.of(2024, 5, 30), SectorType.OTHERS);
        Campaign campaign5 = new Campaign("CardFinance Campaign", "Fee-free and cash advance opportunity", LocalDate.of(2024, 8, 30), SectorType.MARKET);
        Campaign campaign6 = new Campaign("Paraf Campaign for Retirees", "Interest-free cash advance", LocalDate.of(2024, 12, 30), SectorType.MARKET);
        Campaign campaign7 = new Campaign("Paraf Card Campaign", "Fee-free cash advance", LocalDate.of(2024, 12, 30), SectorType.OTHERS);
        Campaign campaign8 = new Campaign("Bonus Card Campaign", "15% discount on cinema tickets", LocalDate.of(2024, 11, 30), SectorType.OTHERS);

        campaign1.setCreditCards(List.of(creditCard3));
        campaign2.setCreditCards(List.of(creditCard3));
        campaign3.setCreditCards(List.of(creditCard1));
        campaign4.setCreditCards(List.of(creditCard1, creditCard2));
        campaign5.setCreditCards(List.of(creditCard2, creditCard3));
        campaign6.setCreditCards(List.of(creditCard1, creditCard3));
        campaign7.setCreditCards(List.of(creditCard1, creditCard2, creditCard3));


        List<Campaign> allCampaigns = List.of(campaign1, campaign2, campaign3, campaign4, campaign5, campaign6, campaign7, campaign8);

        creditCard1.setBank(finansBank);
        creditCard2.setBank(halkBank);
        creditCard3.setBank(garantiBank);

        Application application1 = new Application(user1, LocalDateTime.of(2023, 12, 20, 13, 40), ApplicationStatus.INITIAL, creditCard3);
        Application application2 = new Application(user1, LocalDateTime.of(2024, 2, 25, 16, 45), ApplicationStatus.INITIAL, houseLoan2);
        Application application3 = new Application(user2, LocalDateTime.of(2024, 2, 15, 17, 55), ApplicationStatus.INITIAL, consumerLoan2);
        Application application4 = new Application(user3, LocalDateTime.of(2024, 3, 1, 22, 34), ApplicationStatus.INITIAL, houseLoan3);
        Application application5 = new Application(user3, LocalDateTime.of(2024, 3, 9, 21, 21), ApplicationStatus.INITIAL, houseLoan1);
        Application application6 = new Application(user2, LocalDateTime.of(2023, 12, 13, 13, 14), ApplicationStatus.INITIAL, vehicleLoan1);
        Application application7 = new Application(user3, LocalDateTime.of(2024, 1, 3, 12, 30), ApplicationStatus.INITIAL, creditCard1);

        List<Application> userApplications = List.of(application1, application2, application3, application4, application5, application6, application7);
        User mostApplicantUser = getMostApplicationUser(userApplications);

        System.out.println("Question 3 Name of the user who has most application count: " + mostApplicantUser.getName());
        System.out.println("------------------------------------------------------------------------------------------------------------");

        Map<User, BigDecimal> usersAndLoanApplicationsMap = getUsersAndLoanApplications(userApplications);
        Map<User, BigDecimal> maxLoanApplicationAndUserMap = getUserWithMaxLoanApplication(usersAndLoanApplicationsMap);
        System.out.println("Question 4");
        maxLoanApplicationAndUserMap.forEach((key, value) -> System.out.println("Name of the user has max amount loan application is : " + key.getName() + " , and loan application amount is: " + value));
        System.out.println("------------------------------------------------------------------------------------------------------------");

        List<Application> lastMonthApplications = getLastMonthApplications(userApplications);
        System.out.println("Question 5 Applications within the last 1 month");

        for (Application application : lastMonthApplications) {
            System.out.println("User: " + application.getUser().getName() +
                    ", Date: " + application.getLocalDateTime() +
                    ", Status: " + application.getApplicationStatus() +
                    ", Product: " + application.getProduct().getLoanType() +
                    ", Bank:" + application.getProduct().getBank().getName());
        }
        System.out.println("------------------------------------------------------------------------------------------------------------");

        List<String> sortedCreditCards = sortCreditCardsByCampaignCount(allCampaigns);
        System.out.println("Question 6 Credit Cards and Campaign counts:");
        for (String creditCard : sortedCreditCards) {
            System.out.println(creditCard);
        }
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("Question 7 Applications of the user who has given email");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a mail address !");
        String mailAddress = scanner.nextLine();

        List<Application> applicationOfGivenUser = getApplicationsOfUserByEmail(mailAddress, userApplications);
        if(!applicationOfGivenUser.isEmpty()) {
            for (Application application : applicationOfGivenUser) {
                System.out.println("Given User Mail: " + mailAddress + " Date: " + application.getLocalDateTime() +
                        ", Status: " + application.getApplicationStatus() +
                        ", Product: " + application.getProduct().toString());
            }
        } else {
            System.out.println("There is no application for given user!");
        }
    }

    private User getMostApplicationUser(List<Application> allApplications) {
        Map<User, Integer> applicationCountMap = new HashMap<>();

        for (Application application : allApplications) {
            User user = application.getUser();
            applicationCountMap.put(user, applicationCountMap.getOrDefault(user, 0) + 1);
        }

        User mostApplicationUser = null;
        int maxApplications = 0;

        for (Map.Entry<User, Integer> entry : applicationCountMap.entrySet()) {
            if (entry.getValue() > maxApplications) {
                maxApplications = entry.getValue();
                mostApplicationUser = entry.getKey();
            }
        }

        return mostApplicationUser;

    }

    //Question4
    private Map<User, BigDecimal> getUsersAndLoanApplications(List<Application> allApplications) {
        Map<User, BigDecimal> loanAmountAndUserMap = new HashMap<>();
        List<Application> filteredList = allApplications.stream().filter(f -> !f.getProduct().getLoanType().equals(LoanType.CREDIT_CARD)).toList();
        for (Application application : filteredList) {
            User user = application.getUser();
            Product product = application.getProduct();
            loanAmountAndUserMap.put(user, product.getAmount());
        }
        return loanAmountAndUserMap;
    }

    private Map<User, BigDecimal> getUserWithMaxLoanApplication(Map<User, BigDecimal> usersAndLoans) {
        User userWithMaxAmountLoanDemand = null;
        BigDecimal highestLoanAmount = BigDecimal.ZERO;
        Map<User, BigDecimal> userWithMaxAmountLoanDemandMap = new HashMap<>();
        for (Map.Entry<User, BigDecimal> entry : usersAndLoans.entrySet()) {
            if (entry.getValue().compareTo(highestLoanAmount) > 0) {
                highestLoanAmount = entry.getValue();
                userWithMaxAmountLoanDemand = entry.getKey();
            }
        }
        userWithMaxAmountLoanDemandMap.put(userWithMaxAmountLoanDemand, highestLoanAmount);
        return userWithMaxAmountLoanDemandMap;

    }

    //Question5
    private List<Application> getLastMonthApplications(List<Application> allApplications) {
        LocalDateTime oneMonthAgo = LocalDateTime.now().minusMonths(1);
        List<Application> lastMonthApplications = new ArrayList<>();

        for (Application application : allApplications) {
            if (application.getLocalDateTime().isAfter(oneMonthAgo)) {
                lastMonthApplications.add(application);
            }
        }

        return lastMonthApplications;
    }

    //Question6
    private List<String> sortCreditCardsByCampaignCount(List<Campaign> allCampaigns) {

        Map<String, Long> creditCardCampaignCount = allCampaigns.stream()
                .filter(campaign -> campaign.getCreditCards() != null)
                .flatMap(campaign -> campaign.getCreditCards().stream().map(creditCard -> Map.entry(creditCard.getName(), campaign)))
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.counting()));

        return creditCardCampaignCount.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(entry -> entry.getKey() + " - Campaign count " + entry.getValue())
                .collect(Collectors.toList());
    }

    //Question7
    private List<Application> getApplicationsOfUserByEmail(String email, List<Application> allApplications) {
        List<Application> applicationsOfUserList = new ArrayList<>();
        for (Application application : allApplications) {
            if (email.equals(application.getUser().getEmail())) {
                applicationsOfUserList.add(application);
            }
        }
        return applicationsOfUserList;
    }

    private void onlineShoppingRunner() {
        ProductServiceImpl productServiceImpl = new ProductServiceImpl();
        addProducts(productServiceImpl);

        CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
        addCustomers(customerServiceImpl);

        OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
        addOrders(orderServiceImpl, customerServiceImpl);

        OrderItemServiceImpl orderItemServiceImpl = new OrderItemServiceImpl();
        addOrderItems(orderItemServiceImpl, productServiceImpl);

        List<OrderItem> orderItemList1 = List.of(orderItemServiceImpl.getOrderItems().get(0), orderItemServiceImpl.getOrderItems().get(1));
        List<OrderItem> orderItemList2 = List.of(orderItemServiceImpl.getOrderItems().get(0), orderItemServiceImpl.getOrderItems().get(1), orderItemServiceImpl.getOrderItems().get(2));
        List<OrderItem> orderItemList3 = List.of(orderItemServiceImpl.getOrderItems().get(3), orderItemServiceImpl.getOrderItems().get(4));
        List<OrderItem> orderItemList4 = List.of(orderItemServiceImpl.getOrderItems().get(6), orderItemServiceImpl.getOrderItems().get(7));
        List<OrderItem> orderItemList5 = List.of(orderItemServiceImpl.getOrderItems().get(8), orderItemServiceImpl.getOrderItems().get(0), orderItemServiceImpl.getOrderItems().get(2));
        List<OrderItem> orderItemList6 = List.of(orderItemServiceImpl.getOrderItems().get(5));

        orderServiceImpl.getOrders().get(0).setOrderItems(orderItemList1);
        orderServiceImpl.getOrders().get(1).setOrderItems(orderItemList2);
        orderServiceImpl.getOrders().get(2).setOrderItems(orderItemList3);
        orderServiceImpl.getOrders().get(3).setOrderItems(orderItemList4);
        orderServiceImpl.getOrders().get(4).setOrderItems(orderItemList5);
        orderServiceImpl.getOrders().get(5).setOrderItems(orderItemList6);
        orderServiceImpl.getOrders().get(6).setOrderItems(orderItemList1);
        orderServiceImpl.getOrders().get(7).setOrderItems(orderItemList2);
        orderServiceImpl.getOrders().get(8).setOrderItems(orderItemList4);


        for (Order order : orderServiceImpl.getOrders()) {
            order.completeOrder();
            Bill bill = new Bill();
            bill.setTotalAmount(order.calculateBill());
            order.setBill(bill);
        }

        List<Order> filteredAccTo1500BillsAmount = getOrderMoreThan1500BillAmount(orderServiceImpl.getOrders());

        System.out.println("Invoices over 1500 TL in the system");
        for (Order order : filteredAccTo1500BillsAmount) {
            System.out.println("Total amount: " + order.getBill().getTotalAmount() + " Owner of the order: " + order.getCustomer().getName() + " " + order.getCustomer().getSurname());
        }
        System.out.println("------------------------------------------------------------------------------------------------------------");

        System.out.println("Number of all customers in the system: " + customerServiceImpl.findCustomerCount(customerServiceImpl.getCustomers()));
        System.out.println("------------------------------------------------------------------------------------------------------------");

        int totalProductsBoughtByCemCustomers = getTotalProductsBoughtByCustomer("Cem", orderServiceImpl.getOrders());

        System.out.println("Number of products purchased by customers named Cem : " + totalProductsBoughtByCemCustomers);
        System.out.println("------------------------------------------------------------------------------------------------------------");

        System.out.println("Total shopping amount of customers whose name is Cem and who are younger than 30 and older than 25:  " + calculateTotalAmountForCustomers(orderServiceImpl.getOrders()) + " TL");
        System.out.println("------------------------------------------------------------------------------------------------------------");
    }

    private void addProducts(ProductServiceImpl productServiceImpl) {
        productServiceImpl.addProduct(new com.patika.onlineshoppingservice.models.Product("Jean", ProductType.TEXTILE, 750.0, 20));
        productServiceImpl.addProduct(new com.patika.onlineshoppingservice.models.Product("T-shirt", ProductType.TEXTILE, 400.0, 16));
        productServiceImpl.addProduct(new com.patika.onlineshoppingservice.models.Product("Snow boot", ProductType.TEXTILE, 1200.0, 3));
        productServiceImpl.addProduct(new com.patika.onlineshoppingservice.models.Product("Earphone", ProductType.ELECTRONIC, 1500.0, 5));
        productServiceImpl.addProduct(new com.patika.onlineshoppingservice.models.Product("Office chair", ProductType.FURNITURE, 1000.0, 11));
        productServiceImpl.addProduct(new com.patika.onlineshoppingservice.models.Product("Keyboard", ProductType.ELECTRONIC, 1000.0, 10));
    }

    private void addCustomers(CustomerServiceImpl customerServiceImpl) {
        customerServiceImpl.addCustomer(new Customer("Cem", "Dırman", "38383883", "Izmir", "Turkey", LocalDate.of(1990, 12, 12)));
        customerServiceImpl.addCustomer(new Customer("Cem", "Dırm", "38383822", "Sinop", "Turkey", LocalDate.of(1995, 9, 1)));
        customerServiceImpl.addCustomer(new Customer("Cem", "Dı", "38383883", "Izmir", "Turkey", LocalDate.of(1990, 12, 12)));
        customerServiceImpl.addCustomer(new Customer("Arlo", "B", "38343883", "Ankara", "Turkey", LocalDate.of(1996, 10, 12)));
        customerServiceImpl.addCustomer(new Customer("Onur", "C", "38384883", "Antalya", "Turkey", LocalDate.of(1993, 4, 12)));
        customerServiceImpl.addCustomer(new Customer("Ipek", "C", "38385583", "Izmir", "Turkey", LocalDate.of(1996, 9, 22)));
        customerServiceImpl.addCustomer(new Customer("Osman", "O", "381113883", "İstanbul", "Turkey", LocalDate.of(1995, 6, 1)));
    }

    private void addOrders(OrderServiceImpl orderServiceImpl, CustomerServiceImpl customerServiceImpl) {
        orderServiceImpl.addOrder(new Order(customerServiceImpl.getCustomers().get(0), LocalDateTime.of(2024, 3, 10, 14, 22)));
        orderServiceImpl.addOrder(new Order(customerServiceImpl.getCustomers().get(6), LocalDateTime.of(2024, 3, 11, 13, 45)));
        orderServiceImpl.addOrder(new Order(customerServiceImpl.getCustomers().get(1), LocalDateTime.of(2024, 3, 12, 10, 50)));
        orderServiceImpl.addOrder(new Order(customerServiceImpl.getCustomers().get(3), LocalDateTime.of(2024, 3, 9, 16, 20)));
        orderServiceImpl.addOrder(new Order(customerServiceImpl.getCustomers().get(3), LocalDateTime.of(2024, 3, 9, 15, 9)));
        orderServiceImpl.addOrder(new Order(customerServiceImpl.getCustomers().get(3), LocalDateTime.of(2024, 3, 12, 9, 30)));
        orderServiceImpl.addOrder(new Order(customerServiceImpl.getCustomers().get(2), LocalDateTime.of(2024, 3, 11, 22, 56)));
        orderServiceImpl.addOrder(new Order(customerServiceImpl.getCustomers().get(4), LocalDateTime.of(2024, 3, 10, 12, 30)));
        orderServiceImpl.addOrder(new Order(customerServiceImpl.getCustomers().get(5), LocalDateTime.of(2024, 3, 8, 11, 30)));
    }

    private void addOrderItems(OrderItemServiceImpl orderItemServiceImpl, ProductServiceImpl productServiceImpl) {
        orderItemServiceImpl.addOrderItems(new OrderItem(productServiceImpl.getProducts().get(0), 1));
        orderItemServiceImpl.addOrderItems(new OrderItem(productServiceImpl.getProducts().get(1), 2));
        orderItemServiceImpl.addOrderItems(new OrderItem(productServiceImpl.getProducts().get(4), 3));
        orderItemServiceImpl.addOrderItems(new OrderItem(productServiceImpl.getProducts().get(2), 1));
        orderItemServiceImpl.addOrderItems(new OrderItem(productServiceImpl.getProducts().get(3), 1));
        orderItemServiceImpl.addOrderItems(new OrderItem(productServiceImpl.getProducts().get(5), 1));
        orderItemServiceImpl.addOrderItems(new OrderItem(productServiceImpl.getProducts().get(3), 2));
        orderItemServiceImpl.addOrderItems(new OrderItem(productServiceImpl.getProducts().get(4), 1));
        orderItemServiceImpl.addOrderItems(new OrderItem(productServiceImpl.getProducts().get(2), 4));
    }

    private List<Order> getOrderMoreThan1500BillAmount(List<Order> orderList) {
        List<Order> filteredOrdersList = new ArrayList<>();
        for (Order order : orderList) {
            if (order.getBill().getTotalAmount() > 1500.0) {
                filteredOrdersList.add(order);
            }
        }
        return filteredOrdersList;
    }

    private int getTotalProductsBoughtByCustomer(String name, List<Order> orders) {
        int totalProducts = 0;
        for (Order order : orders) {
            if (order.getCustomer().getName().equals(name) && order.getOrderItems() != null) {
                for (OrderItem orderItem : order.getOrderItems()) {
                    totalProducts += orderItem.getQuantity();
                }
            }
        }
        return totalProducts;
    }

    private double calculateTotalAmountForCustomers(List<Order> orders) {
        double totalAmount = 0;
        LocalDate today = LocalDate.now();

        for (Order order : orders) {
            Customer customer = order.getCustomer();
            int age = Period.between(customer.getBirthDate(), today).getYears();

            if (customer.getName().equals("Cem") && age < 30 && age > 25) {
                totalAmount += order.getBill().getTotalAmount();
            }
        }
        return totalAmount;
    }
}
