import { IncomeControllerService } from "@/generated";
import { useQuery } from "@tanstack/react-query";
import React from "react";
import { Text, View } from "react-native";
import styled from "styled-components/native";

function IncomePage() {
  const { data: incomes } = useQuery({
    queryKey: ["incomeQuery"],
    queryFn: async () => {
      return IncomeControllerService.getIncomes()
        .then((r) => r)
        .catch((e) => {
          console.error("Could not fetch expenses", e);
          return undefined;
        });
    },
  });

  return (
    <MainView>
      {incomes && incomes.map((income, i) => <Text key={i}>{income.id}</Text>)}
    </MainView>
  );
}

export default IncomePage;

const MainView = styled.View`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
`;
