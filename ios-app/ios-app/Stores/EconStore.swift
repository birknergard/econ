internal import Combine
import Foundation

class EconStore: ObservableObject {
    var service: EconService = EconService()

    @Published var expenses: [Expense]
    @Published var incomes: [Income]
    let categories: [String] = [
        "Housing", "Food", "Transport", "Other", "Saving", "Debt",
    ]

    func createExpense(expense: Expense) {
        self.service.createExpense(expense: expense)
    }

    init() {
        self.expenses = self.service.getExpenses()
        self.incomes = [Income]()
    }
}
