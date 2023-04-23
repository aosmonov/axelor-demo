package com.axelor.contact.db.repo;

import com.axelor.contact.db.Address;
import com.axelor.db.JpaRepository;

public class AddressRepository extends JpaRepository<Address> {

  public AddressRepository() {
    super(Address.class);
  }
}
