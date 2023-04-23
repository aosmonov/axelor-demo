package com.axelor.contact.db;

import com.axelor.auth.db.AuditableModel;
import com.axelor.db.annotations.EqualsInclude;
import com.axelor.db.annotations.Widget;
import com.google.common.base.MoreObjects;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Type;

@Entity
@Table(
  name = "CONTACT_TITLE"
)
public class Title extends AuditableModel {

  @Id
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "CONTACT_TITLE_SEQ"
  )
  @SequenceGenerator(
    name = "CONTACT_TITLE_SEQ",
    sequenceName = "CONTACT_TITLE_SEQ",
    allocationSize = 1
  )
  private Long id;

  @EqualsInclude
  @NotNull
  @Size(
    min = 2
  )
  @Column(
    unique = true
  )
  private String code;

  @EqualsInclude
  @NotNull
  @Size(
    min = 2
  )
  @Column(
    unique = true
  )
  private String name;

  @Widget(
    title = "Attributes"
  )
  @Basic(
    fetch = FetchType.LAZY
  )
  @Type(
    type = "json"
  )
  private String attrs;

  public Title() {
  }

  public Title(String code, String name) {
    this.code = code;
    this.name = name;
  }

  @Override
  public Long getId() {
    return id;
  }

  @Override
  public void setId(Long id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAttrs() {
    return attrs;
  }

  public void setAttrs(String attrs) {
    this.attrs = attrs;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) return false;
    if (this == obj) return true;
    if (!(obj instanceof Title)) return false;

    final Title other = (Title) obj;
    if (this.getId() != null || other.getId() != null) {
      return Objects.equals(this.getId(), other.getId());
    }

    return Objects.equals(getCode(), other.getCode())
      && Objects.equals(getName(), other.getName())
      && (getCode() != null
        || getName() != null);
  }

  @Override
  public int hashCode() {
    return 31;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
     .add("id", getId())
      .add("code", getCode())
      .add("name", getName())
      .omitNullValues()
      .toString();
  }
}
