import PageView from "@/components/views/pageView";
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
    <PageView>
      {incomes && incomes.map((income, i) => <Text key={i}>{income.id}</Text>)}
    </PageView>
  );
}

export default IncomePage;
