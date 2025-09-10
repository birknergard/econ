import { PlainText, Title } from "@/components/text";
import React from "react";
import styled from "styled-components/native";

function Index() {
  return (
    <MainView>
      <PlainText>This is the overview page</PlainText>
    </MainView>
  );
}

export default Index;

const MainView = styled.View`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
`;
