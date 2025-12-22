package com.nabadi.composenotes.data

import com.nabadi.composenotes.domain.Note

class InMemoryNotesRepository : NotesRepository {
    override fun getNotes(): List<Note> = listOf(
        Note(
            id = 1,
            title = "Groceries",
            body = "Milk, eggs, bread."
        ),
        Note(
            id = 2,
            title = "Project ideas",
            body = "A small offline-first notes app.\nA habit tracker.\nSomething with Compose + state done right."
        ),
        Note(
            id = 3,
            title = "",
            body = "This note has no title, just text. It should still render correctly."
        ),
        Note(
            id = 4,
            title = "Empty body",
            body = ""
        ),
        Note(
            id = 5,
            title = "One word",
            body = "Done."
        ),
        Note(
            id = 6,
            title = "Meeting notes",
            body = """
            Discussed architecture.
            Agreed to avoid premature abstraction.
            Action item: write things down clearly.
        """.trimIndent()
        ),
        Note(
            id = 7,
            title = "Reminder",
            body = "Call the dentist tomorrow."
        ),
        Note(
            id = 8,
            title = "Random thought",
            body = "Why do most apps feel over-engineered but still buggy?"
        ),
        Note(
            id = 9,
            title = "Quote",
            body = "“Make it work, make it right, make it fast.”"
        ),
        Note(
            id = 10,
            title = "Long title that probably should be truncated in the UI at some point because it just keeps going",
            body = "Short body."
        ),
        Note(
            id = 11,
            title = "Short title",
            body = "This body is intentionally very long to test scrolling behavior, text wrapping, line height, and general readability in the UI. It keeps going without saying much, but that is exactly the point of this note."
        ),
        Note(
            id = 12,
            title = "TODO",
            body = "- Refactor ViewModel\n- Remove side-effects\n- Add tests later"
        ),
        Note(
            id = 13,
            title = "Journal",
            body = "Woke up tired. Coffee helped. Still thinking about architecture more than necessary."
        ),
        Note(
            id = 14,
            title = "",
            body = ""
        ),
        Note(
            id = 15,
            title = "Edge case",
            body = " "
        ),
        Note(
            id = 16,
            title = "Multiline",
            body = "Line one.\nLine two.\nLine three."
        ),
        Note(
            id = 17,
            title = "Numbers",
            body = "1\n2\n3\n4\n5"
        ),
        Note(
            id = 18,
            title = "Symbols",
            body = "!@#\$%^&*()_+-=[]{}|;':\",./<>?"
        ),
        Note(
            id = 19,
            title = "Very long body",
            body = """
            This is a deliberately long note body designed to simulate real user content.
            It has multiple paragraphs.

            Users do not write neatly.
            They write when they are tired, distracted, or emotional.

            Your UI should survive this.
        """.trimIndent()
        ),
        Note(
            id = 20,
            title = "Draft",
            body = "Not finished yet"
        ),
        Note(
            id = 21,
            title = "Idea",
            body = "What if ViewModels were boring again?"
        ),
        Note(
            id = 22,
            title = "Shopping list",
            body = "- Apples\n- Bananas\n- Coffee beans\n- Oat milk"
        ),
        Note(
            id = 23,
            title = "Code snippet",
            body = "fun main() { println(\"Hello\") }"
        ),
        Note(
            id = 24,
            title = "Late night note",
            body = "This made sense at 2am."
        ),
        Note(
            id = 25,
            title = "Question",
            body = "Is this actually needed?"
        ),
        Note(
            id = 26,
            title = "Answer",
            body = "Probably not."
        ),
        Note(
            id = 27,
            title = "Reminder",
            body = "Buy birthday gift."
        ),
        Note(
            id = 28,
            title = "Stream of thought",
            body = "open app -> write thing -> close app -> forget thing"
        ),
        Note(
            id = 29,
            title = "Note",
            body = "Note about nothing in particular."
        ),
        Note(
            id = 30,
            title = "Minimal",
            body = "ok"
        ),
        Note(
            id = 31,
            title = "Long long long long long title",
            body = "Short."
        ),
        Note(
            id = 32,
            title = "Whitespace test",
            body = "    Indented text\n\tTabbed text"
        ),
        Note(
            id = 33,
            title = "Caps",
            body = "THIS IS ALL CAPS"
        ),
        Note(
            id = 34,
            title = "lowercase",
            body = "this is all lowercase"
        ),
        Note(
            id = 35,
            title = "Mixed",
            body = "Some Words Are Capitalized"
        ),
        Note(
            id = 36,
            title = "Emoji",
            body = "🔥🚀🤷‍♀️"
        ),
        Note(
            id = 37,
            title = "List without bullets",
            body = "first\nsecond\nthird"
        ),
        Note(
            id = 38,
            title = "Temporary",
            body = "Delete later."
        ),
        Note(
            id = 39,
            title = "Almost empty",
            body = "."
        ),
        Note(
            id = 40,
            title = "Thought",
            body = "Complexity is easy. Simplicity is hard."
        ),
        Note(
            id = 41,
            title = "Meeting follow-up",
            body = "Send summary email."
        ),
        Note(
            id = 42,
            title = "Bug",
            body = "Repro steps unclear."
        ),
        Note(
            id = 43,
            title = "Fix",
            body = "Stop overthinking."
        ),
        Note(
            id = 44,
            title = "Architecture",
            body = "State flows down. Events flow up."
        ),
        Note(
            id = 45,
            title = "Reminder",
            body = "Water the plants."
        ),
        Note(
            id = 46,
            title = "Scratch",
            body = "asdfghjkl"
        ),
        Note(
            id = 47,
            title = "Draft title",
            body = "Draft body"
        ),
        Note(
            id = 48,
            title = "Final",
            body = "Ship it."
        ),
        Note(
            id = 49,
            title = "Almost there",
            body = "One more thing to check."
        ),
        Note(
            id = 50,
            title = "",
            body = "Last note, no title."
        )
    )

}