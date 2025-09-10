import { Expense, ExpenseControllerService } from "@/generated";
import styled from "styled-components/native";
import { useQuery } from "@tanstack/react-query";
import React, { useState } from "react";
import { FlatList, FlatListComponent, Text, View } from "react-native";
import { Header, LargeText, PlainText, Title } from "@/components/text";

function ExpensePage() {
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
          return undefined;
        });
    },
  });

  const [sum, setSum] = useState(0);

  return (
    <MainView>
      {!expenses ? (
        <PlainText>Loading ...</PlainText>
      ) : (
        <ContentView>
          <Sum>{sum}</Sum>
          <FlatList
            data={expenses}
            keyExtractor={(item: Expense) => item.id}
            renderItem={({ item }) => (
              <PlainText>
                {item.name}: {item.cost}
              </PlainText>
            )}
          />
        </ContentView>
      )}
    </MainView>
  );
}

export default ExpensePage;

const MainView = styled.View`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
`;

const ContentView = styled.View`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
`;

const Sum = styled(LargeText)`
  color: #ff0000;
`;
