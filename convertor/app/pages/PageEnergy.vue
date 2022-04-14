<template>
  <Page>
    <ActionBar title="Энергия" />
    <StackLayout verticalAlignment="top">
      <convertor :ToDefault="ToDefault" :ToNeed="ToNeed" />
    </StackLayout>
  </Page>
</template>

<script>
import Convertor from "@/components/Convertor.vue";

export default {
  data() {
    return {
      ToDefault: {
        "килоджоуль": function (val) {
          return val;
        },
        "джоуль": function (val) {
          return val / 1000;
        },
      },
      ToNeed: {
        "килоджоуль": function (val) {
          return val;
        },
        "джоуль": function (val) {
          return val * 1000;
        },
      },
    };
  },
  components: {
    Convertor,
  },
};
</script>
