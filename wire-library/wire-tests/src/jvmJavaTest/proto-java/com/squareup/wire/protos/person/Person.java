// Code generated by Wire protocol buffer compiler, do not edit.
// Source: squareup.protos.person.Person in person.proto
package com.squareup.wire.protos.person;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.ReverseProtoWriter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireEnum;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.util.List;
import okio.ByteString;

public final class Person extends Message<Person, Person.Builder> {
  public static final ProtoAdapter<Person> ADAPTER = new ProtoAdapter_Person();

  private static final long serialVersionUID = 0L;

  public static final String DEFAULT_NAME = "";

  public static final Integer DEFAULT_ID = 0;

  public static final String DEFAULT_EMAIL = "";

  /**
   * The customer's full name.
   */
  @WireField(
      tag = 1,
      adapter = "com.squareup.wire.ProtoAdapter#STRING",
      label = WireField.Label.REQUIRED
  )
  public final String name;

  /**
   * The customer's ID number.
   */
  @WireField(
      tag = 2,
      adapter = "com.squareup.wire.ProtoAdapter#INT32",
      label = WireField.Label.REQUIRED
  )
  public final Integer id;

  /**
   * Email address for the customer.
   */
  @WireField(
      tag = 3,
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  public final String email;

  /**
   * A list of the customer's phone numbers.
   */
  @WireField(
      tag = 4,
      adapter = "com.squareup.wire.protos.person.Person$PhoneNumber#ADAPTER",
      label = WireField.Label.REPEATED
  )
  public final List<PhoneNumber> phone;

  @WireField(
      tag = 5,
      adapter = "com.squareup.wire.ProtoAdapter#STRING",
      label = WireField.Label.REPEATED
  )
  public final List<String> aliases;

  public Person(String name, Integer id, String email, List<PhoneNumber> phone,
      List<String> aliases) {
    this(name, id, email, phone, aliases, ByteString.EMPTY);
  }

  public Person(String name, Integer id, String email, List<PhoneNumber> phone,
      List<String> aliases, ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.name = name;
    this.id = id;
    this.email = email;
    this.phone = Internal.immutableCopyOf("phone", phone);
    this.aliases = Internal.immutableCopyOf("aliases", aliases);
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.name = name;
    builder.id = id;
    builder.email = email;
    builder.phone = Internal.copyOf(phone);
    builder.aliases = Internal.copyOf(aliases);
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof Person)) return false;
    Person o = (Person) other;
    return unknownFields().equals(o.unknownFields())
        && name.equals(o.name)
        && id.equals(o.id)
        && Internal.equals(email, o.email)
        && phone.equals(o.phone)
        && aliases.equals(o.aliases);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + name.hashCode();
      result = result * 37 + id.hashCode();
      result = result * 37 + (email != null ? email.hashCode() : 0);
      result = result * 37 + phone.hashCode();
      result = result * 37 + aliases.hashCode();
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append(", name=").append(Internal.sanitize(name));
    builder.append(", id=").append(id);
    if (email != null) builder.append(", email=").append(Internal.sanitize(email));
    if (!phone.isEmpty()) builder.append(", phone=").append(phone);
    if (!aliases.isEmpty()) builder.append(", aliases=").append(Internal.sanitize(aliases));
    return builder.replace(0, 2, "Person{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<Person, Builder> {
    public String name;

    public Integer id;

    public String email;

    public List<PhoneNumber> phone;

    public List<String> aliases;

    public Builder() {
      phone = Internal.newMutableList();
      aliases = Internal.newMutableList();
    }

    /**
     * The customer's full name.
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * The customer's ID number.
     */
    public Builder id(Integer id) {
      this.id = id;
      return this;
    }

    /**
     * Email address for the customer.
     */
    public Builder email(String email) {
      this.email = email;
      return this;
    }

    /**
     * A list of the customer's phone numbers.
     */
    public Builder phone(List<PhoneNumber> phone) {
      Internal.checkElementsNotNull(phone);
      this.phone = phone;
      return this;
    }

    public Builder aliases(List<String> aliases) {
      Internal.checkElementsNotNull(aliases);
      this.aliases = aliases;
      return this;
    }

    @Override
    public Person build() {
      if (name == null
          || id == null) {
        throw Internal.missingRequiredFields(name, "name",
            id, "id");
      }
      return new Person(name, id, email, phone, aliases, super.buildUnknownFields());
    }
  }

  public enum PhoneType implements WireEnum {
    MOBILE(0),

    HOME(1),

    /**
     * Could be phone or fax.
     */
    WORK(2);

    public static final ProtoAdapter<PhoneType> ADAPTER = new ProtoAdapter_PhoneType();

    private final int value;

    PhoneType(int value) {
      this.value = value;
    }

    /**
     * Return the constant for {@code value} or null.
     */
    public static PhoneType fromValue(int value) {
      switch (value) {
        case 0: return MOBILE;
        case 1: return HOME;
        case 2: return WORK;
        default: return null;
      }
    }

    @Override
    public int getValue() {
      return value;
    }

    private static final class ProtoAdapter_PhoneType extends EnumAdapter<PhoneType> {
      ProtoAdapter_PhoneType() {
        super(PhoneType.class, Syntax.PROTO_2, PhoneType.MOBILE);
      }

      @Override
      protected PhoneType fromValue(int value) {
        return PhoneType.fromValue(value);
      }
    }
  }

  public static final class PhoneNumber extends Message<PhoneNumber, PhoneNumber.Builder> {
    public static final ProtoAdapter<PhoneNumber> ADAPTER = new ProtoAdapter_PhoneNumber();

    private static final long serialVersionUID = 0L;

    public static final String DEFAULT_NUMBER = "";

    public static final PhoneType DEFAULT_TYPE = PhoneType.HOME;

    /**
     * The customer's phone number.
     */
    @WireField(
        tag = 1,
        adapter = "com.squareup.wire.ProtoAdapter#STRING",
        label = WireField.Label.REQUIRED
    )
    public final String number;

    /**
     * The type of phone stored here.
     */
    @WireField(
        tag = 2,
        adapter = "com.squareup.wire.protos.person.Person$PhoneType#ADAPTER"
    )
    public final PhoneType type;

    public PhoneNumber(String number, PhoneType type) {
      this(number, type, ByteString.EMPTY);
    }

    public PhoneNumber(String number, PhoneType type, ByteString unknownFields) {
      super(ADAPTER, unknownFields);
      this.number = number;
      this.type = type;
    }

    @Override
    public Builder newBuilder() {
      Builder builder = new Builder();
      builder.number = number;
      builder.type = type;
      builder.addUnknownFields(unknownFields());
      return builder;
    }

    @Override
    public boolean equals(Object other) {
      if (other == this) return true;
      if (!(other instanceof PhoneNumber)) return false;
      PhoneNumber o = (PhoneNumber) other;
      return unknownFields().equals(o.unknownFields())
          && number.equals(o.number)
          && Internal.equals(type, o.type);
    }

    @Override
    public int hashCode() {
      int result = super.hashCode;
      if (result == 0) {
        result = unknownFields().hashCode();
        result = result * 37 + number.hashCode();
        result = result * 37 + (type != null ? type.hashCode() : 0);
        super.hashCode = result;
      }
      return result;
    }

    @Override
    public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append(", number=").append(Internal.sanitize(number));
      if (type != null) builder.append(", type=").append(type);
      return builder.replace(0, 2, "PhoneNumber{").append('}').toString();
    }

    public static final class Builder extends Message.Builder<PhoneNumber, Builder> {
      public String number;

      public PhoneType type;

      public Builder() {
      }

      /**
       * The customer's phone number.
       */
      public Builder number(String number) {
        this.number = number;
        return this;
      }

      /**
       * The type of phone stored here.
       */
      public Builder type(PhoneType type) {
        this.type = type;
        return this;
      }

      @Override
      public PhoneNumber build() {
        if (number == null) {
          throw Internal.missingRequiredFields(number, "number");
        }
        return new PhoneNumber(number, type, super.buildUnknownFields());
      }
    }

    private static final class ProtoAdapter_PhoneNumber extends ProtoAdapter<PhoneNumber> {
      public ProtoAdapter_PhoneNumber() {
        super(FieldEncoding.LENGTH_DELIMITED, PhoneNumber.class, "type.googleapis.com/squareup.protos.person.Person.PhoneNumber", Syntax.PROTO_2, null);
      }

      @Override
      public int encodedSize(PhoneNumber value) {
        int result = 0;
        result += ProtoAdapter.STRING.encodedSizeWithTag(1, value.number);
        result += PhoneType.ADAPTER.encodedSizeWithTag(2, value.type);
        result += value.unknownFields().size();
        return result;
      }

      @Override
      public void encode(ProtoWriter writer, PhoneNumber value) throws IOException {
        ProtoAdapter.STRING.encodeWithTag(writer, 1, value.number);
        PhoneType.ADAPTER.encodeWithTag(writer, 2, value.type);
        writer.writeBytes(value.unknownFields());
      }

      @Override
      public void encode(ReverseProtoWriter writer, PhoneNumber value) throws IOException {
        writer.writeBytes(value.unknownFields());
        PhoneType.ADAPTER.encodeWithTag(writer, 2, value.type);
        ProtoAdapter.STRING.encodeWithTag(writer, 1, value.number);
      }

      @Override
      public PhoneNumber decode(ProtoReader reader) throws IOException {
        Builder builder = new Builder();
        long token = reader.beginMessage();
        for (int tag; (tag = reader.nextTag()) != -1;) {
          switch (tag) {
            case 1: builder.number(ProtoAdapter.STRING.decode(reader)); break;
            case 2: {
              try {
                builder.type(PhoneType.ADAPTER.decode(reader));
              } catch (ProtoAdapter.EnumConstantNotFoundException e) {
                builder.addUnknownField(tag, FieldEncoding.VARINT, (long) e.value);
              }
              break;
            }
            default: {
              reader.readUnknownField(tag);
            }
          }
        }
        builder.addUnknownFields(reader.endMessageAndGetUnknownFields(token));
        return builder.build();
      }

      @Override
      public PhoneNumber redact(PhoneNumber value) {
        Builder builder = value.newBuilder();
        builder.clearUnknownFields();
        return builder.build();
      }
    }
  }

  private static final class ProtoAdapter_Person extends ProtoAdapter<Person> {
    public ProtoAdapter_Person() {
      super(FieldEncoding.LENGTH_DELIMITED, Person.class, "type.googleapis.com/squareup.protos.person.Person", Syntax.PROTO_2, null);
    }

    @Override
    public int encodedSize(Person value) {
      int result = 0;
      result += ProtoAdapter.STRING.encodedSizeWithTag(1, value.name);
      result += ProtoAdapter.INT32.encodedSizeWithTag(2, value.id);
      result += ProtoAdapter.STRING.encodedSizeWithTag(3, value.email);
      result += PhoneNumber.ADAPTER.asRepeated().encodedSizeWithTag(4, value.phone);
      result += ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(5, value.aliases);
      result += value.unknownFields().size();
      return result;
    }

    @Override
    public void encode(ProtoWriter writer, Person value) throws IOException {
      ProtoAdapter.STRING.encodeWithTag(writer, 1, value.name);
      ProtoAdapter.INT32.encodeWithTag(writer, 2, value.id);
      ProtoAdapter.STRING.encodeWithTag(writer, 3, value.email);
      PhoneNumber.ADAPTER.asRepeated().encodeWithTag(writer, 4, value.phone);
      ProtoAdapter.STRING.asRepeated().encodeWithTag(writer, 5, value.aliases);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public void encode(ReverseProtoWriter writer, Person value) throws IOException {
      writer.writeBytes(value.unknownFields());
      ProtoAdapter.STRING.asRepeated().encodeWithTag(writer, 5, value.aliases);
      PhoneNumber.ADAPTER.asRepeated().encodeWithTag(writer, 4, value.phone);
      ProtoAdapter.STRING.encodeWithTag(writer, 3, value.email);
      ProtoAdapter.INT32.encodeWithTag(writer, 2, value.id);
      ProtoAdapter.STRING.encodeWithTag(writer, 1, value.name);
    }

    @Override
    public Person decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 1: builder.name(ProtoAdapter.STRING.decode(reader)); break;
          case 2: builder.id(ProtoAdapter.INT32.decode(reader)); break;
          case 3: builder.email(ProtoAdapter.STRING.decode(reader)); break;
          case 4: builder.phone.add(PhoneNumber.ADAPTER.decode(reader)); break;
          case 5: builder.aliases.add(ProtoAdapter.STRING.decode(reader)); break;
          default: {
            reader.readUnknownField(tag);
          }
        }
      }
      builder.addUnknownFields(reader.endMessageAndGetUnknownFields(token));
      return builder.build();
    }

    @Override
    public Person redact(Person value) {
      Builder builder = value.newBuilder();
      Internal.redactElements(builder.phone, PhoneNumber.ADAPTER);
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}
