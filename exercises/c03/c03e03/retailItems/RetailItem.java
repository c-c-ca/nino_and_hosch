package retailItems;

/**
 * A retail item in an inventory.
 */
public class RetailItem {

  // Private components:

  private double basePrice;     // base price for this RetailItem
  private double discountRate;  // discount rate as a decimal fraction
  private double taxRate;       // tax rate as a decimal fraction

  // Constructors:

  /**
   * Create a RetailItem with the specified base price, discount rate,
   * and tax rate. Base price is the prive before discount and tax.
   * Dicount and tax rates are given as decimal fractions. For instance, a 10%
   * discount is indicated by 0.10.
   */
  public RetailItem (double basePrice, double discountRate, double taxRate) {
      this.basePrice = basePrice;
      this.discountRate = discountRate;
      this.taxRate = taxRate;
  }

  // Queries:

  /**
   * This RetailItem's net price, computed by subtracting discount and adding
   * tax to discounted amount.
   */
  public double netPrice () {
      return discountedPrice() + taxCharged();
  }

  /**
   * Amount of tax charged on this RetailItem.
   */
  public double taxCharged (){
      return discountedPrice() * taxRate;
  }

  /**
   * Price of this RetialItem, including discount.
   */
  public double discountedPrice (){
      return basePrice - basePrice * discountRate;
  }

  /**
   * Base price of this RetailItem.
   */
  public double basePrice () {
      return basePrice;
  }

  /**
   * Discount rate for this RetailItem, as a decimal fraction: for example 0.08 for 8%
   */
  public double discountRate () {
      return discountRate;
  }

  /**
   * Tax rate for this RetailItem, as a decimal fraction: for example 0.25 for 25%
   */
  public double taxRate () {
      return taxRate;
  }

  /**
   * A String representation of this RetailItem.
   */
  public String toString () {
      return "Retail Item: base price = " + basePrice +
             ", discount rate = " + discountRate +
             ", tax rate = " + taxRate;
  }

  // Commands:

  /**
   * Change this RetailItem's tax rate to the specified value.  value must be
   * a non-negative double.
   */
  public void changeTaxRate (double value) {
      this.taxRate = value;
  }

  /**
   * Change this RetailItem's discount rate to the specified value.  value must be
   * a non-negative double.
   */
  public void changeDiscountRate (double value) {
      this.discountRate = value;
  }

}
