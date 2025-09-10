import { Expense, ExpenseControllerService } from "@/generated";
import styled from "styled-components/native";
import { useQuery } from "@tanstack/react-query";
import React, { useState } from "react";
import { FlatList } from "react-native";
import { LargeText, PlainText } from "@/components/text";
import PageView from "@/components/views/pageView";

function ExpensePage() {
  const [sum, setSum] = useState(0);
  const { data: expenses } = useQuery({
    queryKey: ["expenseQuery"],
    queryFn: async () => {
      return ExpenseControllerService.getExpenses()
        .then((r) => {
          setSum(() => r.reduce((current, next) => current + next.cost, 0));
          return r;
        })
        .catch((e) => {
          console.error("Could not fetch expenses", e);
          return [];
        });
    },
  });

  return (
    <PageView>
      {!expenses ? (
        <PlainText>Loading ...</PlainText>
      ) : (
        <>
          <Sum>{sum}</Sum>
          <ExpenseView />
          <FlatList
            data={expenses}
            keyExtractor={(item: Expense) => item.id}
            renderItem={({ item }) => (
              <PlainText>
                {item.name}: {item.cost}
              </PlainText>
            )}
          />
          <ExpenseView />
        </>
      )}
    </PageView>
  );
}

export default ExpensePage;

const Sum = styled(LargeText)`
  color: #ff0000;
`;

const ExpenseView = styled.View``;
