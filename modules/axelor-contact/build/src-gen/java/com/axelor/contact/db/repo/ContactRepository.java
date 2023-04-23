package com.axelor.contact.db.repo;

import com.axelor.contact.db.Contact;
import com.axelor.db.JpaRepository;
import com.axelor.db.Query;

public class ContactRepository extends JpaRepository<Contact> {

  public ContactRepository() {
    super(Contact.class);
  }

  public Contact findByName(String fullName) {
    return Query.of(Contact.class)
      .filter("self.fullName = :fullName")
      .bind("fullName", fullName)
      .fetchOne();
  }

  public Contact findByEmail(String email) {
    return Query.of(Contact.class)
      .filter("self.email = :email")
      .bind("email", email)
      .fetchOne();
  }
}
