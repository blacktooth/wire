// Code generated by Wire protocol buffer compiler, do not edit.
// Source: squareup.protos.kotlin.foreign.ForeignMessage in foreign.proto
package com.squareup.wire.protos.kotlin.foreign

import com.squareup.wire.FieldEncoding
import com.squareup.wire.Message
import com.squareup.wire.ProtoAdapter
import com.squareup.wire.ProtoReader
import com.squareup.wire.ProtoWriter
import com.squareup.wire.ReverseProtoWriter
import com.squareup.wire.Syntax.PROTO_2
import com.squareup.wire.WireField
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Unit
import kotlin.jvm.JvmField
import okio.ByteString

public class ForeignMessage(
  @field:WireField(
    tag = 1,
    adapter = "com.squareup.wire.ProtoAdapter#INT32"
  )
  @JvmField
  public val i: Int? = null,
  /**
   * Extension source: simple_message.proto
   */
  @field:WireField(
    tag = 100,
    adapter = "com.squareup.wire.ProtoAdapter#INT32"
  )
  @JvmField
  public val j: Int? = null,
  unknownFields: ByteString = ByteString.EMPTY
) : Message<ForeignMessage, ForeignMessage.Builder>(ADAPTER, unknownFields) {
  public override fun newBuilder(): Builder {
    val builder = Builder()
    builder.i = i
    builder.j = j
    builder.addUnknownFields(unknownFields)
    return builder
  }

  public override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is ForeignMessage) return false
    if (unknownFields != other.unknownFields) return false
    if (i != other.i) return false
    if (j != other.j) return false
    return true
  }

  public override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = unknownFields.hashCode()
      result = result * 37 + (i?.hashCode() ?: 0)
      result = result * 37 + (j?.hashCode() ?: 0)
      super.hashCode = result
    }
    return result
  }

  public override fun toString(): String {
    val result = mutableListOf<String>()
    if (i != null) result += """i=$i"""
    if (j != null) result += """j=$j"""
    return result.joinToString(prefix = "ForeignMessage{", separator = ", ", postfix = "}")
  }

  public fun copy(
    i: Int? = this.i,
    j: Int? = this.j,
    unknownFields: ByteString = this.unknownFields
  ): ForeignMessage = ForeignMessage(i, j, unknownFields)

  public class Builder : Message.Builder<ForeignMessage, Builder>() {
    @JvmField
    public var i: Int? = null

    @JvmField
    public var j: Int? = null

    public fun i(i: Int?): Builder {
      this.i = i
      return this
    }

    public fun j(j: Int?): Builder {
      this.j = j
      return this
    }

    public override fun build(): ForeignMessage = ForeignMessage(
      i = i,
      j = j,
      unknownFields = buildUnknownFields()
    )
  }

  public companion object {
    @JvmField
    public val ADAPTER: ProtoAdapter<ForeignMessage> = object : ProtoAdapter<ForeignMessage>(
      FieldEncoding.LENGTH_DELIMITED, 
      ForeignMessage::class, 
      "type.googleapis.com/squareup.protos.kotlin.foreign.ForeignMessage", 
      PROTO_2, 
      null
    ) {
      public override fun encodedSize(`value`: ForeignMessage): Int {
        var size = value.unknownFields.size
        size += ProtoAdapter.INT32.encodedSizeWithTag(1, value.i)
        size += ProtoAdapter.INT32.encodedSizeWithTag(100, value.j)
        return size
      }

      public override fun encode(writer: ProtoWriter, `value`: ForeignMessage): Unit {
        ProtoAdapter.INT32.encodeWithTag(writer, 1, value.i)
        ProtoAdapter.INT32.encodeWithTag(writer, 100, value.j)
        writer.writeBytes(value.unknownFields)
      }

      public override fun encode(writer: ReverseProtoWriter, `value`: ForeignMessage): Unit {
        writer.writeBytes(value.unknownFields)
        ProtoAdapter.INT32.encodeWithTag(writer, 100, value.j)
        ProtoAdapter.INT32.encodeWithTag(writer, 1, value.i)
      }

      public override fun decode(reader: ProtoReader): ForeignMessage {
        var i: Int? = null
        var j: Int? = null
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> i = ProtoAdapter.INT32.decode(reader)
            100 -> j = ProtoAdapter.INT32.decode(reader)
            else -> reader.readUnknownField(tag)
          }
        }
        return ForeignMessage(
          i = i,
          j = j,
          unknownFields = unknownFields
        )
      }

      public override fun redact(`value`: ForeignMessage): ForeignMessage = value.copy(
        unknownFields = ByteString.EMPTY
      )
    }

    private const val serialVersionUID: Long = 0L
  }
}
