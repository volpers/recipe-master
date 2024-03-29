import type { Metadata } from "next";
import { Inter } from "next/font/google";
//import "./globals.css";
import { AppRouterCacheProvider } from '@mui/material-nextjs/v13-appRouter';
import { ThemeProvider } from '@mui/material/styles';
import theme from '../theme';
import {CssBaseline} from "@mui/material";

const inter = Inter({ subsets: ["latin"] });

export const metadata: Metadata = {
  title: "The Recipe Master"
};

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="de">
      <body className={inter.className}>
      <AppRouterCacheProvider>
        <CssBaseline/>
        <ThemeProvider theme={theme}>
          {children}
        </ThemeProvider>
      </AppRouterCacheProvider>
      </body>
    </html>
  );
}
