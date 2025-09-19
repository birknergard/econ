//
//  ExpensesView.swift
//  ios
//
//  Created by Birk Kristinius Nergård on 17/09/2025.
//

import SwiftUI

struct ExpensesView: View {
    @State var sum: Int = 999_999  // Test value

    var body: some View {
        VStack {
            VStack {
                Text("Sum of expenses (Monthly)")
                    .font(.system(size: 25))
                HStack {
                    Image(systemName: "minus")
                        .resizable()
                        .frame(width: 25, height: 5)
                    Text("\(sum),-")
                        .font(.system(size: 70))
                }
                .foregroundColor(.red)
                Spacer()
                    .frame(height: 20)
            }
            .overlay(  // Bottom border
                Rectangle()
                    .frame(height: 2)
                    .foregroundColor(.gray), alignment: .bottom
            )

            ZStack(alignment: .bottomTrailing) {
                ScrollView {
                    VStack {
                        CategoryTable(title: "Housing", color: .gray)
                    }
                    .frame(maxWidth: .infinity, maxHeight: .infinity)
                }
                Button(action: {
                    /* POST MODAL OPEN */
                }) {
                    Image(systemName: "plus.square.fill")
                        .resizable()
                        .frame(width: 45, height: 45)
                        .background(Circle().fill(.white))
                        .foregroundColor(.red)
                }
                .padding()
                .buttonStyle(PlainButtonStyle())
            }
            .frame(
                maxWidth: .infinity,
                maxHeight: .infinity,
            )
            .padding()
        }
        .frame(
            maxWidth: .infinity,
            alignment: .top
        )
        .padding(.top, 50)
    }
}
