import Foundation

public struct Expense: Codable, Identifiable {
    public var id: String
    public var name: String
    public var cost: Double
    public var category: String
}

public struct ExpensesByCategory: Codable {
    public var housing: [Expense]
    public var food: [Expense]
    public var transport: [Expense]
    public var other: [Expense]
    public var savings: [Expense]
    public var debt: [Expense]
    public var listSum: Double
}
