import { ExpenseControllerService } from "@/generated";
import { useQuery } from "@tanstack/react-query";
import React from "react";
import { Text, View } from "react-native";

function Index() {
  const { data: expenses } = useQuery({
    queryKey: ["expenseQuery"],
    queryFn: async () => {
      return ExpenseControllerService.getExpenses()
        .then((r) => r)
        .catch((e) => {
          console.error("Could not fetch expenses", e);
          return undefined;
        });
    },
  });

  return (
    <View className={styles.main}>
      <Text>Hello world</Text>
    </View>
  );
}

export default Index;

const styles = {
  main: "w-full bg-sky-500 flex content-center ",
};
