import styles from "./page.module.css";
import Link from "next/link";

export default function Home() {
  return (
    <main className={styles.main}>
      HELLO WORLD!
        <Link href={"/recipes"}>Recipes</Link>
    </main>
  );
}
