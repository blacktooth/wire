// Code generated by Wire protocol buffer compiler, do not edit.
// Source: squareup.protos.kotlin.edgecases.OneField in edge_cases.proto
package com.squareup.wire.protos.kotlin.edgecases

import com.squareup.wire.FieldEncoding
import com.squareup.wire.Message
import com.squareup.wire.ProtoAdapter
import com.squareup.wire.ProtoReader
import com.squareup.wire.ProtoWriter
import com.squareup.wire.ReverseProtoWriter
import com.squareup.wire.Syntax.PROTO_2
import com.squareup.wire.WireField
import kotlin.Any
import kotlin.AssertionError
import kotlin.Boolean
import kotlin.Deprecated
import kotlin.DeprecationLevel
import kotlin.Int
import kotlin.Long
import kotlin.Nothing
import kotlin.String
import kotlin.Unit
import kotlin.jvm.JvmField
import okio.ByteString

public class OneField(
  @field:WireField(
    tag = 1,
    adapter = "com.squareup.wire.ProtoAdapter#INT32"
  )
  public val opt_int32: Int? = null,
  unknownFields: ByteString = ByteString.EMPTY
) : Message<OneField, Nothing>(ADAPTER, unknownFields) {
  @Deprecated(
    message = "Shouldn't be used in Kotlin",
    level = DeprecationLevel.HIDDEN
  )
  public override fun newBuilder(): Nothing = throw
      AssertionError("Builders are deprecated and only available in a javaInterop build; see https://square.github.io/wire/wire_compiler/#kotlin")

  public override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is OneField) return false
    if (unknownFields != other.unknownFields) return false
    if (opt_int32 != other.opt_int32) return false
    return true
  }

  public override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = unknownFields.hashCode()
      result = result * 37 + (opt_int32?.hashCode() ?: 0)
      super.hashCode = result
    }
    return result
  }

  public override fun toString(): String {
    val result = mutableListOf<String>()
    if (opt_int32 != null) result += """opt_int32=$opt_int32"""
    return result.joinToString(prefix = "OneField{", separator = ", ", postfix = "}")
  }

  public fun copy(opt_int32: Int? = this.opt_int32, unknownFields: ByteString = this.unknownFields):
      OneField = OneField(opt_int32, unknownFields)

  public companion object {
    @JvmField
    public val ADAPTER: ProtoAdapter<OneField> = object : ProtoAdapter<OneField>(
      FieldEncoding.LENGTH_DELIMITED, 
      OneField::class, 
      "type.googleapis.com/squareup.protos.kotlin.edgecases.OneField", 
      PROTO_2, 
      null
    ) {
      public override fun encodedSize(`value`: OneField): Int {
        var size = value.unknownFields.size
        size += ProtoAdapter.INT32.encodedSizeWithTag(1, value.opt_int32)
        return size
      }

      public override fun encode(writer: ProtoWriter, `value`: OneField): Unit {
        ProtoAdapter.INT32.encodeWithTag(writer, 1, value.opt_int32)
        writer.writeBytes(value.unknownFields)
      }

      public override fun encode(writer: ReverseProtoWriter, `value`: OneField): Unit {
        writer.writeBytes(value.unknownFields)
        ProtoAdapter.INT32.encodeWithTag(writer, 1, value.opt_int32)
      }

      public override fun decode(reader: ProtoReader): OneField {
        var opt_int32: Int? = null
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> opt_int32 = ProtoAdapter.INT32.decode(reader)
            else -> reader.readUnknownField(tag)
          }
        }
        return OneField(
          opt_int32 = opt_int32,
          unknownFields = unknownFields
        )
      }

      public override fun redact(`value`: OneField): OneField = value.copy(
        unknownFields = ByteString.EMPTY
      )
    }

    private const val serialVersionUID: Long = 0L
  }
}
