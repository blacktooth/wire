// Code generated by Wire protocol buffer compiler, do not edit.
// Source: squareup.protos.ChildPackage in child_pkg.proto
package com.squareup.wire.protos;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.ReverseProtoWriter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.squareup.wire.protos.foreign.ForeignEnum;
import java.io.IOException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import okio.ByteString;

public final class ChildPackage extends Message<ChildPackage, ChildPackage.Builder> {
  public static final ProtoAdapter<ChildPackage> ADAPTER = new ProtoAdapter_ChildPackage();

  private static final long serialVersionUID = 0L;

  public static final ForeignEnum DEFAULT_INNER_FOREIGN_ENUM = ForeignEnum.BAV;

  @WireField(
      tag = 1,
      adapter = "com.squareup.wire.protos.foreign.ForeignEnum#ADAPTER"
  )
  public final ForeignEnum inner_foreign_enum;

  public ChildPackage(ForeignEnum inner_foreign_enum) {
    this(inner_foreign_enum, ByteString.EMPTY);
  }

  public ChildPackage(ForeignEnum inner_foreign_enum, ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.inner_foreign_enum = inner_foreign_enum;
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.inner_foreign_enum = inner_foreign_enum;
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof ChildPackage)) return false;
    ChildPackage o = (ChildPackage) other;
    return unknownFields().equals(o.unknownFields())
        && Internal.equals(inner_foreign_enum, o.inner_foreign_enum);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + (inner_foreign_enum != null ? inner_foreign_enum.hashCode() : 0);
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (inner_foreign_enum != null) builder.append(", inner_foreign_enum=").append(inner_foreign_enum);
    return builder.replace(0, 2, "ChildPackage{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<ChildPackage, Builder> {
    public ForeignEnum inner_foreign_enum;

    public Builder() {
    }

    public Builder inner_foreign_enum(ForeignEnum inner_foreign_enum) {
      this.inner_foreign_enum = inner_foreign_enum;
      return this;
    }

    @Override
    public ChildPackage build() {
      return new ChildPackage(inner_foreign_enum, super.buildUnknownFields());
    }
  }

  private static final class ProtoAdapter_ChildPackage extends ProtoAdapter<ChildPackage> {
    public ProtoAdapter_ChildPackage() {
      super(FieldEncoding.LENGTH_DELIMITED, ChildPackage.class, "type.googleapis.com/squareup.protos.ChildPackage", Syntax.PROTO_2, null);
    }

    @Override
    public int encodedSize(ChildPackage value) {
      int result = 0;
      result += ForeignEnum.ADAPTER.encodedSizeWithTag(1, value.inner_foreign_enum);
      result += value.unknownFields().size();
      return result;
    }

    @Override
    public void encode(ProtoWriter writer, ChildPackage value) throws IOException {
      ForeignEnum.ADAPTER.encodeWithTag(writer, 1, value.inner_foreign_enum);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public void encode(ReverseProtoWriter writer, ChildPackage value) throws IOException {
      writer.writeBytes(value.unknownFields());
      ForeignEnum.ADAPTER.encodeWithTag(writer, 1, value.inner_foreign_enum);
    }

    @Override
    public ChildPackage decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 1: {
            try {
              builder.inner_foreign_enum(ForeignEnum.ADAPTER.decode(reader));
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
    public ChildPackage redact(ChildPackage value) {
      Builder builder = value.newBuilder();
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}
