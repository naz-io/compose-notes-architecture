# Compose Notes Architecture

---

## 1. Purpose of This Repository

This repository exists to demonstrate **one very specific thing**:

> How to build a Jetpack Compose screen where state, lifecycle, and side-effects are explicit — and where recomposition cannot accidentally trigger work.

Jetpack Compose makes UI easy.
It also makes it very easy to quietly do the wrong thing:

- load data multiple times
- hide side-effects in places no one expects
- rely on `init {}`
- couple rendering with control flow

This repo uses a simple notes list to show a disciplined baseline:

- state is owned in one place
- UI renders state and nothing else
- side-effects are visible and centralized
- loading happens once, on purpose

The goal is not abstraction or flexibility.
The goal is to make incorrect wiring hard to introduce accidentally.

---

## 2. State Ownership Strategy

All UI state for the notes list lives in the ViewModel.
This is not theoretical — it is enforced by the structure of the code.

NotesListViewModel exposes a single:

`StateFlow<NotesListUiState>`

That state fully describes what the screen should render:

- loading
- error
- empty
- content

There is no additional state hidden in composables.

The composables themselves are intentionally stateless.

They:
- take uiState
- render it
- do nothing else

They do NOT:
- remember flags
- infer state
- keep temporary booleans that quietly become permanent later

The reason is simple:

Recomposition should never change behavior.

If state leaks into the UI, you eventually get bugs where:
- loading runs more than once
- navigating back resets things unexpectedly
- previews don’t match real behavior
- fixing one issue causes another

Keeping state in the ViewModel makes the UI boring.
Boring here is a feature.

---

## 3. Side-Effects: Rules and Placement (Most Important)

There is exactly one side-effect in this screen:

`LaunchedEffect(Unit) { viewModel.loadNotes() }`

This is intentional.

The screen needs to load data once when it becomes active.
That is the only moment where work should happen.

Why LaunchedEffect:

- lifecycle-aware
- automatically cancelled if the screen leaves composition
- no manual coroutine management

Why the key is Unit:

The intent is run once per screen entry.
Not once per recomposition.
Not once per state change.
Not “whenever something feels different”.

Unit makes that contract explicit.

Why it lives at the Route level:

The side-effect lives in the Route, not:
- inside the screen
- inside UI elements
- inside list items
- inside the ViewModel init {}

The Route is where:
- lifecycle awareness exists
- ViewModel wiring happens
- orchestration is allowed

Putting this deeper would make rendering trigger work.
Putting it in init {} would hide when loading happens.

Here, intent is visible in one place:

When the screen enters, notes load.

If someone skims this file and can’t answer
“when does loading happen?”, the design failed.

---

## 4. Intentional Omissions

Several things are missing on purpose:

- Paging  
  Paging would blur the core “load once” behavior.

- Retry logic  
  Retries introduce branching side-effects too early.

- Flow collection inside UI elements  
  All collection happens at the Route level to avoid recomposition bugs.

- Detail screen / navigation complexity  
  Extra screens dilute the signal.

- Multiple side-effects  
  One effect keeps causality obvious.

This repo is not incomplete.
It is constrained by design.

---

## 5. What Would Change at Larger Scale

This structure scales, but it would not stay exactly like this forever.

If the app grew:
- the manual ViewModel factory would be replaced with DI
- UI state might be split or structured further
- error handling would become more nuanced
- loading would become asynchronous

What would NOT change:
- state stays in the ViewModel
- UI stays pure
- side-effects stay centralized and explicit
- UI never decides when work happens

Those decisions are the point of this repo.

Missing pieces were postponed intentionally so the important ones stay visible.

---

## Final Note

This repository is not optimized for feature velocity.
It is optimized for clarity of intent.

If someone can read this code and immediately understand:
- when work happens
- why it happens

then the architecture is doing its job.
