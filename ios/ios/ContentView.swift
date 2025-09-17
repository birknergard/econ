//
//  ContentView.swift
//  ios
//
//  Created by Birk Kristinius Nergård on 17/09/2025.
//

import SwiftData
import SwiftUI

struct ContentView: View {
    var body: some View {
        NavigationStack {
            TabView {
                ExpensesView().tabItem {
                    Text("Expenses")
                    Image(systemName: "minus.square")
                }

                HomeView().tabItem {
                    Text("Home")
                    Image(systemName: "house")
                }

                IncomesView().tabItem {
                    Text("Incomes")
                    Image(systemName: "plus.square")
                }

            }
        }
    }
}

#Preview {
    ContentView()
}
