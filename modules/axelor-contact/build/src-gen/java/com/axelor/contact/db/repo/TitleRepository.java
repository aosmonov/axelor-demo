package com.axelor.contact.db.repo;

import com.axelor.contact.db.Title;
import com.axelor.db.JpaRepository;
import com.axelor.db.Query;

public class TitleRepository extends JpaRepository<Title> {

  public TitleRepository() {
    super(Title.class);
  }

  public Title findByCode(String code) {
    return Query.of(Title.class)
      .filter("self.code = :code")
      .bind("code", code)
      .fetchOne();
  }

  public Title findByName(String name) {
    return Query.of(Title.class)
      .filter("self.name = :name")
      .bind("name", name)
      .fetchOne();
  }
}
