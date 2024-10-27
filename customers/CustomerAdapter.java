public class CustomerAdapter {
    public ExternalCustomerData adaptCustomer(Customer customer) {
        ExternalCustomerData externalData = new ExternalCustomerData();
        externalData.setName(customer.getName());
        externalData.setPhone(customer.getPhone());
        externalData.setType(customer.getType());
        return externalData;
    }
}
