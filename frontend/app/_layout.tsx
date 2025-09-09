import { Stack } from "expo-router";
import "../globals.css";
import { QueryClient, QueryClientProvider } from "@tanstack/react-query";

export default function Layout() {
  const queryClient = new QueryClient();

  return (
    <QueryClientProvider client={queryClient}>
      <Stack>
        <Stack.Screen name="(tabs)" options={{ headerShown: false }} />
      </Stack>
    </QueryClientProvider>
  );
}
