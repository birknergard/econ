//
//  CategoryTable.swift
//  ios
//
//  Created by Birk Kristinius Nergård on 17/09/2025.
//

import SwiftUI

struct CategoryTable: View {
    var title: String
    var items: [Expense] = []
    var color: Color = .gray
    var categoryTotal: Double = 999_999  // Test value

    var body: some View {
        HStack {
            Text("\(title)")
            Spacer()
            Text("\(String(format: "%.2f", categoryTotal)),-")
            Button(action: {
                // Modal active/deactivate
            }) {
                Image(systemName: "chevron.down")
                    .resizable()
                    .aspectRatio(contentMode: .fit)
                    .frame(width: 30, height: 30)
                    .padding(.leading, 15)
            }.buttonStyle(.plain)
        }
        .font(.title2)
        .padding()
        .foregroundColor(.white)
        .frame(maxWidth: .infinity, maxHeight: .infinity)
        .background(color)
        .cornerRadius(8)
    }
}
