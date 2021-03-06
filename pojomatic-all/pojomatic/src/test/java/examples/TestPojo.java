package examples;

import org.pojomatic.Pojomatic;
import org.pojomatic.annotations.Property;
import org.pojomatic.annotations.PropertyFormat;
import org.pojomatic.formatter.AccountNumberFormatter;

public class TestPojo {
  @Property
  private boolean test;

  @Property
  @PropertyFormat(AccountNumberFormatter.class)
  private String creditCardNumber;

  private String ignored;

  @Property
  public String derived() {
    return String.valueOf(System.currentTimeMillis());
  }

  @SuppressWarnings("unused")
  @Property
  private String privateString() {
    return ignored + derived();
  }

  public boolean isTest() {
    return this.test;
  }

  public void setTest(boolean test) {
    this.test = test;
  }

  public String getCreditCardNumber() {
    return this.creditCardNumber;
  }

  public void setCreditCardNumber(String creditCardNumber) {
    this.creditCardNumber = creditCardNumber;
  }

  public String getIgnored() {
    return this.ignored;
  }

  public void setIgnored(String ignored) {
    this.ignored = ignored;
  }

  @Override public int hashCode() {
    return Pojomatic.hashCode(this);
  }

  @Override public String toString() {
    return Pojomatic.toString(this);
  }

  @Override public boolean equals(Object o) {
    return Pojomatic.equals(this, o);
  }
}
