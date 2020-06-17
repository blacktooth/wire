//
//  Copyright © 2020 Square Inc. All rights reserved.
//

import Foundation

/**
 A class responsible for turning bytes from a serialized protocol buffer message
 into an in-memory struct representing that message.

 General usage will look something like:
 ```
 let decoder = ProtoDecoder()
 let decodedMessage = try decoder.decode(GeneratedMessageType.self, from: data)
 ```
 */
public final class ProtoDecoder {

    // MARK: -

    public enum Error: Swift.Error, LocalizedError {

        case invalidStructure(message: String)

        case malformedVarint

        /** 
         An error thrown when a field that is marked as `required` is not included
         in the data being decoded
         */
        case missingRequiredField(typeName: String, fieldName: String)

        case unexpectedEndOfData

        var localizedDescription: String {
            switch self {
            case let .invalidStructure(message):
                return "Message structure is invalid: \(message)."
            case .malformedVarint:
                return "Encoded varint was not in the correct format."
            case let .missingRequiredField(typeName, fieldName):
                return "Required field \(fieldName) is missing for type \(typeName)."
            case .unexpectedEndOfData:
                return "A field indicates that its data extends beyond the end of the available message data."
            }
        }
    }

    // MARK: - Initialization

    public init() {}

    // MARK: - Public Methods

    public func decode<T: ProtoDecodable>(_ type: T.Type, from data: Data) throws -> T {
        fatalError("TODO")
    }

}

