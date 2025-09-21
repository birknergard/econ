import Foundation

enum ExpenseList {
    case unsorted([Expense])
    case sorted(ExpensesByCategory)
}

struct EconService {
    private final let base: String = "http://localhost:8080/api"
    private final let expenseUrl: String = "\(url)/expense"
    private final let incomeUrl: String = "\(url)/income"

    func createExpense(expense: Expense) {
        // Create request
        guard let url = URL(string: expenseUrl) else { return }
        var request = URLRequest(url: url)

        // Set request body
        request.httpMethod = "POST"
        request.setValue("application/json", forHTTPHeaderField: "Content-Type")
        request.httpBody = try? JSONSerialization.data(withJSONObject: expense)

        // Define request process via task
        let task = URLSession.shared.dataTask(with: request) { data, response, error in

            // Error handling
            if let error = error {
                print("Error with request: \(error)")
                return
            }

            // Handle response
            guard let data = data else { return }
            print("Response: \(String(data: data, encoding: .utf8) ?? "")")
        }

        // Send request
        task.resume()
    }
}
