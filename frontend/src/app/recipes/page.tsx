import Link from "next/link";
export default function RecipesPage() {
    return(
        <>
            Here are the recipes!
            <Link href={"/recipes/details"}>Details!</Link>
        </>
    )
}