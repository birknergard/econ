import Foundation

public struct Income: Codable, Identifiable {
    public var id: String
    public var name: String
    public var amount: Double
}
