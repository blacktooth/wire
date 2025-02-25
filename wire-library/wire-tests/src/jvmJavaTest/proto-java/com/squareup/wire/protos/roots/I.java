// Code generated by Wire protocol buffer compiler, do not edit.
// Source: squareup.protos.roots.I in roots.proto
package com.squareup.wire.protos.roots;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.ReverseProtoWriter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import okio.ByteString;

public final class I extends Message<I, I.Builder> {
  public static final ProtoAdapter<I> ADAPTER = new ProtoAdapter_I();

  private static final long serialVersionUID = 0L;

  public static final Integer DEFAULT_I = 0;

  @WireField(
      tag = 1,
      adapter = "com.squareup.wire.ProtoAdapter#INT32"
  )
  public final Integer i;

  /**
   * Extension source: roots.proto
   */
  @WireField(
      tag = 1000,
      adapter = "com.squareup.wire.protos.roots.J#ADAPTER"
  )
  public final J j;

  public I(Integer i, J j) {
    this(i, j, ByteString.EMPTY);
  }

  public I(Integer i, J j, ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.i = i;
    this.j = j;
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.i = i;
    builder.j = j;
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof I)) return false;
    I o = (I) other;
    return unknownFields().equals(o.unknownFields())
        && Internal.equals(i, o.i)
        && Internal.equals(j, o.j);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + (i != null ? i.hashCode() : 0);
      result = result * 37 + (j != null ? j.hashCode() : 0);
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (i != null) builder.append(", i=").append(i);
    if (j != null) builder.append(", j=").append(j);
    return builder.replace(0, 2, "I{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<I, Builder> {
    public Integer i;

    public J j;

    public Builder() {
    }

    public Builder i(Integer i) {
      this.i = i;
      return this;
    }

    public Builder j(J j) {
      this.j = j;
      return this;
    }

    @Override
    public I build() {
      return new I(i, j, super.buildUnknownFields());
    }
  }

  private static final class ProtoAdapter_I extends ProtoAdapter<I> {
    public ProtoAdapter_I() {
      super(FieldEncoding.LENGTH_DELIMITED, I.class, "type.googleapis.com/squareup.protos.roots.I", Syntax.PROTO_2, null);
    }

    @Override
    public int encodedSize(I value) {
      int result = 0;
      result += ProtoAdapter.INT32.encodedSizeWithTag(1, value.i);
      result += J.ADAPTER.encodedSizeWithTag(1000, value.j);
      result += value.unknownFields().size();
      return result;
    }

    @Override
    public void encode(ProtoWriter writer, I value) throws IOException {
      ProtoAdapter.INT32.encodeWithTag(writer, 1, value.i);
      J.ADAPTER.encodeWithTag(writer, 1000, value.j);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public void encode(ReverseProtoWriter writer, I value) throws IOException {
      writer.writeBytes(value.unknownFields());
      J.ADAPTER.encodeWithTag(writer, 1000, value.j);
      ProtoAdapter.INT32.encodeWithTag(writer, 1, value.i);
    }

    @Override
    public I decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 1: builder.i(ProtoAdapter.INT32.decode(reader)); break;
          case 1000: builder.j(J.ADAPTER.decode(reader)); break;
          default: {
            reader.readUnknownField(tag);
          }
        }
      }
      builder.addUnknownFields(reader.endMessageAndGetUnknownFields(token));
      return builder.build();
    }

    @Override
    public I redact(I value) {
      Builder builder = value.newBuilder();
      if (builder.j != null) builder.j = J.ADAPTER.redact(builder.j);
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}
