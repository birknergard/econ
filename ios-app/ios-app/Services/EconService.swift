import Foundation

struct EconService {
    private let expenseUrl: String = "http://localhost:8080/api/econ/expense"
    private let incomeUrl: String = "http://localhost:8080/api/econ/income"

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
