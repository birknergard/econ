import Foundation

struct EconService {
    private let expenseUrl: String = "http://localhost:8080/api/econ/expense"
    private let incomeUrl: String = "http://localhost:8080/api/econ/income"

    func getExpenses() async {
        // Create request
        guard let url = URL(string: expenseUrl) else { return }
        var request = URLRequest(url: url)

        // Set request body
        request.httpMethod = "GET"
        request.setValue("application/json", forHTTPHeaderField: "Content-Type")
        
        // Prepare request
        let task = URLSession.shared.dataTask(with: request) {
            data,
            response,
            error in

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

    func createExpense(expense: Expense) async {
        // Create request
        guard let url = URL(string: expenseUrl) else { return }
        var request = URLRequest(url: url)

        // Set request body
        request.httpMethod = "POST"
        request.setValue("application/json", forHTTPHeaderField: "Content-Type")

        do {
            let encoder = JSONEncoder()
            encoder.outputFormatting = .prettyPrinted
            request.httpBody = try encoder.encode(expense)
            let task = URLSession.shared.dataTask(with: request) {
                data,
                response,
                error in

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
        } catch {

        }

    }
}
