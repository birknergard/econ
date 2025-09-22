import Foundation

public struct Expense: Codable {
    var id: String
    var name: String
    var cost: Double
    var category: String
}

public struct ExpensesByCategory: Codable {
    var housing: [Expense]
    var food: [Expense]
    var transport: [Expense]
    var other: [Expense]
    var savings: [Expense]
    var debt: [Expense]
    var listSum: Double
}
